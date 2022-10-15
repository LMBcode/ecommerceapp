package com.example.myecommerceapp.f.data

import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.example.myecommerceapp.f.domain.ShoeRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.sync.Mutex

internal class RealShoeRepository() : ShoeRepository {

	// we should add mutex but that's for later, until ConcurrentModificationException
	// when trying to use specific dispatcher
	private val mutex = Mutex()

	private val shoeObserver = mutableListOf<ShoeObserver>()
	private val shoeMap = ShoeProvider.shoeList.associateBy { it.id }.toMutableMap()

	override fun observeAvailableShoes(): Flow<List<String>> {
		return callbackFlow {
			send(shoeMap.keys.toList())

			val observer = ShoeObserver.Available { new ->
				trySend(new)
			}

			shoeObserver.add(observer)

			awaitClose {
				shoeObserver.remove(observer)
			}
		}
	}

	override fun observeImageForId(id: String): Flow<Int> {
		return callbackFlow {
			shoeMap[id]?.image?.let { send(it) }

			val observer = ShoeObserver.Image { changedId, new ->
				if (changedId == id) trySend(new)
			}

			shoeObserver.add(observer)

			awaitClose {
				shoeObserver.remove(observer)
			}
		}
	}

	override fun observeFavForId(id: String): Flow<Boolean> {
		return callbackFlow {
			shoeMap[id]?.fav?.let { send(it) }

			val observer = ShoeObserver.Fav { changedId, new ->
				if (changedId == id) trySend(new)
			}

			shoeObserver.add(observer)

			awaitClose {
				shoeObserver.remove(observer)
			}
		}
	}

	override fun observeNameForId(id: String): Flow<String> {
		return callbackFlow {
			shoeMap[id]?.name?.let { send(it) }

			val observer = ShoeObserver.Name { changedId, new ->
				if (changedId == id) trySend(new)
			}

			shoeObserver.add(observer)

			awaitClose {
				shoeObserver.remove(observer)
			}
		}
	}

	override fun observePriceForId(id: String): Flow<Double> {
		return callbackFlow {
			shoeMap[id]?.price?.let { send(it) }

			val observer = ShoeObserver.Price { changedId, new ->
				if (changedId == id) trySend(new)
			}

			shoeObserver.add(observer)

			awaitClose {
				shoeObserver.remove(observer)
			}
		}
	}

	override fun changeFavForId(id: String, fav: Boolean) {
		shoeMap[id]?.let { current ->
			if (current.fav == fav) return
			shoeMap[id] = current.copy(fav = fav)
			notifyChangedFav(id, fav)
		}
	}

	override fun getShoeFront(id: String): Int = shoeMap[id]?.front ?: ResourcesCompat.ID_NULL
	override fun getShoeBack(id: String): Int = shoeMap[id]?.front ?: ResourcesCompat.ID_NULL
	override fun getShoeSide(id: String): Int = shoeMap[id]?.front ?: ResourcesCompat.ID_NULL

	private fun notifyChangedFav(id: String, fav: Boolean) {
		shoeObserver.forEach { observer ->
			if (observer is ShoeObserver.Fav) observer.favChanged(id, fav)
		}
	}

	private sealed interface ShoeObserver {

		fun interface Available : ShoeObserver {
			fun availableChanged(new: List<String>)
		}

		fun interface Name : ShoeObserver {
			fun nameChanged(id: String, new: String)
		}

		fun interface Image : ShoeObserver {
			fun imageChanged(id: String, new: Int)
		}

		fun interface Fav : ShoeObserver {
			fun favChanged(id: String, new: Boolean)
		}

		fun interface Price : ShoeObserver {
			fun priceChanged(id: String, new: Double)
		}
	}
}