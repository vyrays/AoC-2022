package net.aoc.two

class Two : Day {

    override lateinit var action: Action
    override lateinit var response: Response

    override fun setDayResponse(response: String): Day {
        this.response = when (response) {
            // X - lose
            "X" -> when (action) {
                Action.ROCK -> Response.SCISSORS
                Action.PAPER -> Response.ROCK
                Action.SCISSORS -> Response.PAPER
            }
            // Y - draw
            "Y" -> when (action) {
                Action.ROCK -> Response.ROCK
                Action.PAPER -> Response.PAPER
                Action.SCISSORS -> Response.SCISSORS
            }
            // Z - win
            "Z" -> when (action) {
                Action.ROCK -> Response.PAPER
                Action.PAPER -> Response.SCISSORS
                Action.SCISSORS -> Response.ROCK
            }

            else -> Response.ROCK
        }

        return this
    }

}