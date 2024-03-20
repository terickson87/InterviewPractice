package interviewpractice;

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.test.Test
import kotlin.test.assertNotNull

public class CountStringInstancesTest : BehaviorSpec({

    given("2 pattern matches") {
        val countStringInstances = CountStringInstances()
        val pattern = "abr"
        val findIn = "abracadabra"

        `when`("countInstances") {
            val count = countStringInstances.countStringInstances(pattern, findIn)

            then("return 2") {
                count.shouldBe(2)
            }
        }
    }

    given("1 pattern match") {
        val countStringInstances = CountStringInstances()
        val pattern = "abr"
        val findIn = "abracadab"

        `when`("countInstances") {
            val count = countStringInstances.countStringInstances(pattern, findIn)

            then("return 1") {
                count.shouldBe(1)
            }
        }
    }

    given("0 pattern match") {
        val countStringInstances = CountStringInstances()
        val pattern = "bat"
        val findIn = "abracadabra"

        `when`("countInstances") {
            val count = countStringInstances.countStringInstances(pattern, findIn)

            then("return 0") {
                count.shouldBe(0)
            }
        }
    }

})