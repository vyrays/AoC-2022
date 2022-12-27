package net.aoc.two

class One : Day {

    override lateinit var action: Action
    override lateinit var response: Response

    override fun setDayResponse(response: String): Day {
        this.response = when (response) {
            "X" -> Response.ROCK
            "Y" -> Response.PAPER
            "Z" -> Response.SCISSORS
            else -> Response.ROCK
        }

        return this
    }

}