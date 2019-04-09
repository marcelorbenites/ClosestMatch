package com.marcerlorbenites.closestevent

import java.util.*

class MatchCalendar {

    /**
     *
     * Return the closest match index to [dateClicked], return 0 otherwise,
    [matchList] is sorted by date.
     *
     * @return index of [matchList] closest event
     */
    fun findClosestEvent(dateClicked: Date, matchList: List<Match>): Int {

        val selectedDate = Calendar.getInstance()
        selectedDate.timeInMillis = dateClicked.time

        val pastDate: Calendar = Calendar.getInstance()
        pastDate.timeInMillis = 0
        var pastDateIndex = -1

        val futureDate: Calendar = Calendar.getInstance()
        futureDate.timeInMillis = Long.MAX_VALUE
        var futureDateIndex = -1

        val matchDate = Calendar.getInstance()
        matchList.forEachIndexed { index, match ->
            matchDate.time = match.date

            if (matchDate == selectedDate) {
                return index
            }

            if (matchDate.before(selectedDate) && matchDate.after(pastDate)) {
                pastDate.time = matchDate.time
                pastDateIndex = index
            }

            if (matchDate.before(futureDate) && matchDate.after(selectedDate)) {
                futureDate.time = matchDate.time
                futureDateIndex = index
            }
        }

        return if (pastDateIndex != -1) {
            if (futureDateIndex != -1) {
                if (selectedDate.timeInMillis - pastDate.timeInMillis > futureDate.timeInMillis - selectedDate.timeInMillis) {
                    return futureDateIndex
                } else {
                    pastDateIndex
                }
            } else {
                pastDateIndex
            }
        } else {
            0
        }
    }
}
