import java.util.Random;
import java.util.Scanner;

class SafariAdventure {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalPoints = 0;
        boolean survived = true;

        System.out.println("🌄 Welcome to Safari Adventure!");
        System.out.println("You have 5 days to explore the safari.");
        System.out.println("Goal: Collect at least 100 points and survive!\n");

        // ==========================================
        // FOR LOOP - 5 Days of Safari Exploration
        // ==========================================
        for (int day = 1; day <= 5; day++) {

            int dailyPoints = 0;

            System.out.println("-----------------------------------");
            System.out.println("Day " + day + ":");

            // ==========================================
            // DO...WHILE LOOP - Area Selection
            // ==========================================
            String area;

            do {
                System.out.print(
                    "Where would you like to explore? " +
                    "(Jungle, River, Desert, Mountains): "
                );

                area = scanner.nextLine().trim();

                if (!area.equalsIgnoreCase("Jungle") &&
                    !area.equalsIgnoreCase("River") &&
                    !area.equalsIgnoreCase("Desert") &&
                    !area.equalsIgnoreCase("Mountains")) {

                    System.out.println(
                        "Invalid area. Please choose again."
                    );
                }

            } while (!area.equalsIgnoreCase("Jungle") &&
                     !area.equalsIgnoreCase("River") &&
                     !area.equalsIgnoreCase("Desert") &&
                     !area.equalsIgnoreCase("Mountains"));

            System.out.println("\nYou chose: " + area);
            System.out.println("Exploring " + area + "...");

            // ==========================================
            // WHILE LOOP - Random Events
            // ==========================================
            int eventNumber = 1;
            boolean enoughResources = false;

            while (eventNumber <= 3 && !enoughResources) {

                int event = random.nextInt(5);

                System.out.println("\nEvent " + eventNumber + ":");

                // ------------------------------------------
                // Event 1: Harmless Bird
                // Demonstrates CONTINUE
                // ------------------------------------------
                if (event == 0) {

                    System.out.println(
                        "You spotted a bird. 🐦"
                    );
                    System.out.println(
                        "(Too small to track. Moving on.)"
                    );

                    eventNumber++;

                    // Skip the rest of this iteration
                    continue;
                }

                // ------------------------------------------
                // Event 2: Find Resources
                // ------------------------------------------
                else if (event == 1) {

                    int points = (random.nextInt(4) + 1) * 5;

                    System.out.println(
                        "You found useful resources! " +
                        "(+" + points + " points)"
                    );

                    dailyPoints += points;
                    totalPoints += points;

                    // If player gets enough resources
                    // for the day, stop the event loop.
                    if (dailyPoints >= 30) {
                        System.out.println(
                            "You found enough resources " +
                            "for today!"
                        );

                        enoughResources = true;
                    }
                }

                // ------------------------------------------
                // Event 3: Food
                // ------------------------------------------
                else if (event == 2) {

                    System.out.println(
                        "You found edible berries! 🍓 (+15 points)"
                    );

                    dailyPoints += 15;
                    totalPoints += 15;

                }

                // ------------------------------------------
                // Event 4: Weather Hazard
                // ------------------------------------------
                else if (event == 3) {

                    System.out.println(
                        "A sudden weather hazard appears! ⛈️"
                    );

                    System.out.println(
                        "You lose 5 points from your supplies."
                    );

                    dailyPoints -= 5;
                    totalPoints -= 5;

                    // Prevent total points from going below 0
                    if (totalPoints < 0) {
                        totalPoints = 0;
                    }
                }

                // ------------------------------------------
                // Event 5: Dangerous Animal
                // Demonstrates BREAK
                // ------------------------------------------
                else {

                    String animal;

                    if (area.equalsIgnoreCase("River")) {
                        animal = "crocodile";
                    } else {
                        animal = "lion";
                    }

                    System.out.println(
                        "A dangerous " + animal +
                        " appears! 😱"
                    );

                    System.out.print(
                        "Type 'run' to escape: "
                    );

                    String response = scanner.nextLine().trim();

                    if (response.equalsIgnoreCase("run")) {

                        System.out.println(
                            "You escaped safely, " +
                            "ending the day early."
                        );

                        // Exit the event loop for this day
                        break;

                    } else {

                        System.out.println(
                            "You did not run in time!"
                        );

                        System.out.println(
                            "The safari adventure has ended."
                        );

                        survived = false;

                        // Exit the event loop
                        break;
                    }
                }

                eventNumber++;
            }

            // ==========================================
            // DAILY SUMMARY
            // ==========================================
            System.out.println("\nDay Summary:");
            System.out.println(
                "Points earned today: " + dailyPoints
            );
            System.out.println(
                "Total points so far: " + totalPoints
            );

            // If player did not survive, stop the
            // 5-day safari early.
            if (!survived) {
                break;
            }

            System.out.println();
        }

        // ==========================================
        // FINAL SUMMARY
        // ==========================================
        System.out.println("\n===================================");
        System.out.println("🎉 Safari Adventure Summary");
        System.out.println("===================================");

        System.out.println(
            "Total points collected: " + totalPoints
        );

        if (survived && totalPoints >= 100) {

            System.out.println(
                "🎉 Safari Complete!"
            );
            System.out.println(
                "You survived and collected at least 100 points!"
            );
            System.out.println(
                "You survived and completed the adventure!"
            );

        } else if (survived) {

            System.out.println(
                "You survived the safari, but you did not " +
                "collect enough resources."
            );

            System.out.println(
                "You needed 100 points but collected " +
                totalPoints + "."
            );

        } else {

            System.out.println(
                "The adventure ended early."
            );
            System.out.println(
                "You did not survive the safari."
            );
        }

        scanner.close();
    }
}