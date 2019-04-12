# Closest Match

Simple application to find the closest match in a calendar of football matches given a date.

## Build

`./gradlew build`

## Unit Tests

`./gradlew check`

## Algorithm

Iterate through the list and keep the closest past date and the closest future date in variables. Update them as we loop through the matches. After all the matches are verified whether weather past date or future date is the closest to the one that was received as parameter. The time complexity is linear **O(n)**.

