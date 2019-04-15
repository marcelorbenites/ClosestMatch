# Closest Match

Simple application to find the closest match in a calendar of football matches given a date.

## Build

`./gradlew build`

## Unit Tests

`./gradlew check`

## Algorithm

Iterate through the list and keep the closest past date and the closest future date in variables. Update them as we loop through the matches. After all the matches are verified check weather past date or future date is the closest to the one that was received as parameter. The time complexity is linear **O(n)**.

**PS:** After discussing with a friend I've noticed I could improve the algorithm to **O(log(n))** time complexity by continously dividing the list. Since I've already delivered, I will not change it. We can discuss it further if we end-up having an interview.

