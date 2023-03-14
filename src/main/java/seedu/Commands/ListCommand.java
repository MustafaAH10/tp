package seedu.commands;

import seedu.database.FoodStorage;
import seedu.database.MealStorage;
import seedu.database.UserStorage;
import seedu.exceptions.LifeTrackerException;
import seedu.exceptions.InvalidArgumentsException;
//import seedu.Output.UI;
import seedu.ui.GeneralUi;

public class ListCommand extends Command {
    private String argument;

    public ListCommand(String commandWord, String userInput) throws InvalidArgumentsException {
        if (commandWord.length() == userInput.length() || userInput.split(" ").length < 2) {
            throw new InvalidArgumentsException(commandWord);
        }

        this.argument = userInput.split(" ")[1];

        if (!this.argument.equals("meals") && !this.argument.equals("foods")) {
            throw new InvalidArgumentsException(commandWord);
        }
    }

    @Override
    public void execute(GeneralUi ui, FoodStorage foodStorage,
                        MealStorage mealStorage, UserStorage userStorage) throws LifeTrackerException {
        if (argument.equals("meals")) {
            ui.printAllMeals(mealStorage);
        } else {
            ui.printAllFoods(foodStorage);
        }
    }
}
