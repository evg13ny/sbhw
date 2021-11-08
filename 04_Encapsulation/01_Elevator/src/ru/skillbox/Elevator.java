package ru.skillbox;

public class Elevator {

    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {

        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {

        if (floor >= minFloor && floor <= maxFloor && floor != currentFloor && floor != 0) {

            if (floor > currentFloor) {
                for (int i = currentFloor; i < floor; i++) {
                    moveUp();
                    if (currentFloor == 0) continue;
                    System.out.println("Текущий этаж: " + getCurrentFloor());
                }
            }

            if (floor < currentFloor) {
                for (int i = currentFloor; i > floor; i--) {
                    moveDown();
                    if (currentFloor == 0) continue;
                    System.out.println("Текущий этаж: " + getCurrentFloor());
                }
            }

        } else if (floor == currentFloor) {
            System.out.println("Вы выбрали текущий этаж. Текущий этаж: " + getCurrentFloor());
        } else {
            System.out.println("Вы выбрали некорректный этаж. Выберите корректный этаж.");
        }
    }
}