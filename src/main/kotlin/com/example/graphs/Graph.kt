package com.example.graphs

import java.util.LinkedList
import java.util.Queue

data class Person(
	val name: String,
	val isMangoSeller: Boolean,
	val friends: MutableSet<Person> = LinkedHashSet(),
)

object Graph {

	fun breadthFirstSearch(person: Person) {
		var shortestMangoSeller: Person? = null
		val verifiedPersons: MutableList<String> = mutableListOf()

		// Initializing the network with the friends of the first element
		val myQueue: Queue<Person> = LinkedList(person.friends)

		while (myQueue.isNotEmpty()) {
			// Extracting first element
			val currentPerson = myQueue.poll()
			println("Checking ${currentPerson.name}")

			// Verifying if the current element is already a mango seller
			if (currentPerson.isMangoSeller) {
				shortestMangoSeller = currentPerson
				break
			} else {
				// Otherwise, include the unverified friends of the current element into the queue
				currentPerson.friends
					.filter {
						!verifiedPersons.contains(it.name)
					}
					.apply {
						myQueue.addAll(this)
						verifiedPersons.addAll(this.map { it.name })
					}

			}
		}

		shortestMangoSeller?.let {
			println("The shortest mango seller is ${it.name}")
		} ?: println("There's no mango seller in your network")
	}
}
