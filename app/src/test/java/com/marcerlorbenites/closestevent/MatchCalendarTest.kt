package com.marcerlorbenites.closestevent

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class MatchCalendarTest {

    @Test
    fun `Given an empty list of matches And a date When closest match index is requested Then return 0`() {
        val matchCalendar = MatchCalendar()

        val date = GregorianCalendar(2019, 4, 20, 20, 0).time
        val matchList = emptyList<Match>()
        assertEquals(0, matchCalendar.findClosestEvent(date, matchList))
    }

    @Test
    fun `Given a list of matches And a date And there is a match exactly in the date When closest match index is requested Then return match index`() {
        val matchCalendar = MatchCalendar()

        val pastDate = GregorianCalendar(2019, 4, 15, 20, 0).time
        val date = GregorianCalendar(2019, 4, 20, 20, 0).time
        val futureDate = GregorianCalendar(2019, 4, 21, 20, 0).time
        val reallyFutureDate = GregorianCalendar(2022, 4, 25, 20, 0).time
        val matchList = listOf(
            Match("Football", pastDate, "West Ham", "Tottenham"),
            Match("Football", date, "Arsenal", "Manchester City"),
            Match("Football", futureDate, "Everton", "Southampton"),
            Match("Football", reallyFutureDate, "Leicester City", "Newcastle United")
        )
        assertEquals(1, matchCalendar.findClosestEvent(date, matchList))
    }

    @Test
    fun `Given a list of matches And a date And the closest match is in a date in the past When closest match index is requested Then return past match index`() {
        val matchCalendar = MatchCalendar()

        val reallyPastDate = GregorianCalendar(2007, 4, 25, 20, 0).time
        val pastDate = GregorianCalendar(2019, 4, 19, 20, 0).time
        val date = GregorianCalendar(2019, 4, 20, 20, 0).time
        val futureDate = GregorianCalendar(2019, 4, 25, 20, 0).time
        val reallyFutureDate = GregorianCalendar(2022, 4, 25, 20, 0).time
        val matchList = listOf(
            Match("Football", reallyPastDate, "West Ham", "Tottenham"),
            Match("Football", pastDate, "Arsenal", "Manchester City"),
            Match("Football", futureDate, "Everton", "Southampton"),
            Match("Football", reallyFutureDate, "Leicester City", "Newcastle United")
        )
        assertEquals(1, matchCalendar.findClosestEvent(date, matchList))
    }

    @Test
    fun `Given a list of matches And a date And the closest match is in a date in the future When closest match index is requested Then return future match index`() {
        val matchCalendar = MatchCalendar()

        val reallyPastDate = GregorianCalendar(2007, 4, 25, 20, 0).time
        val pastDate = GregorianCalendar(2019, 4, 15, 20, 0).time
        val date = GregorianCalendar(2019, 4, 20, 20, 0).time
        val futureDate = GregorianCalendar(2019, 4, 21, 20, 0).time
        val reallyFutureDate = GregorianCalendar(2022, 4, 25, 20, 0).time
        val matchList = listOf(
            Match("Football", reallyPastDate, "West Ham", "Tottenham"),
            Match("Football", pastDate, "Arsenal", "Manchester City"),
            Match("Football", futureDate, "Everton", "Southampton"),
            Match("Football", reallyFutureDate, "Leicester City", "Newcastle United")
        )
        assertEquals(2, matchCalendar.findClosestEvent(date, matchList))
    }

    @Test
    fun `Given a date And a list of matches where all matches are after the date When closest match index is requested Then return future match index`() {
        val matchCalendar = MatchCalendar()

        val date = GregorianCalendar(2019, 4, 20, 20, 0).time
        val futureDate = GregorianCalendar(2019, 4, 21, 20, 0).time
        val reallyFutureDate = GregorianCalendar(2022, 4, 25, 20, 0).time
        val matchList = listOf(
            Match("Football", futureDate, "Everton", "Southampton"),
            Match("Football", reallyFutureDate, "Leicester City", "Newcastle United")
        )
        assertEquals(0, matchCalendar.findClosestEvent(date, matchList))
    }

    @Test
    fun `Given a date And a list of matches where all matches are before the date When closest match index is requested Then return past match index`() {
        val matchCalendar = MatchCalendar()

        val reallyPastDate = GregorianCalendar(2007, 4, 25, 20, 0).time
        val pastDate = GregorianCalendar(2019, 4, 15, 20, 0).time
        val date = GregorianCalendar(2019, 4, 20, 20, 0).time
        val matchList = listOf(
            Match("Football", reallyPastDate, "West Ham", "Tottenham"),
            Match("Football", pastDate, "Arsenal", "Manchester City")
        )
        assertEquals(1, matchCalendar.findClosestEvent(date, matchList))
    }
}
