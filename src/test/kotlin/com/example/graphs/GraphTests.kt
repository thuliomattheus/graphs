package com.example.graphs

import org.junit.jupiter.api.Test

class GraphTests {

	@Test
	fun test() {
		val me = Person(name = "Thúlio", isMangoSeller = false)
		val drogba = Person(name = "Drogba", isMangoSeller = false)
		val terry = Person(name = "Terry", isMangoSeller = false)
		val lampard = Person(name = "Lampard", isMangoSeller = false)
		val cech = Person(name = "Cech", isMangoSeller = false)
		val hazard = Person(name = "Hazard", isMangoSeller = false)
		val kante = Person(name = "Kante", isMangoSeller = false)
		val fabregas = Person(name = "Fabregas", isMangoSeller = false)
		val bridge = Person(name = "Bridge", isMangoSeller = false)
		val gallas = Person(name = "Gallas", isMangoSeller = false)
		val zezinho = Person(name = "Zé", isMangoSeller = true)
		val huguinho = Person(name = "Hugo", isMangoSeller = true)

		// Setting relations
		me.friends.add(drogba)
		me.friends.add(hazard)
		drogba.friends.add(lampard)
		drogba.friends.add(cech)
		drogba.friends.add(terry)
		terry.friends.add(gallas)
		terry.friends.add(bridge)
		bridge.friends.add(zezinho)
		hazard.friends.add(drogba)
		hazard.friends.add(kante)
		hazard.friends.add(fabregas)
		kante.friends.add(huguinho)

		Graph.breadthFirstSearch(me)
	}
}
