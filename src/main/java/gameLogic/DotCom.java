package gameLogic;

import java.util.List;

public class DotCom {
    private List<String> locationCells;
    private String name;

    public List<String> getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(List<String> locationCells) {
        this.locationCells = locationCells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Ой, Вы потопили " + name + "  :( ");
            } else {
                result = "Попал";
            }
        }
        return result;
    }package util;
