package by.epam.task5.controller.helper;

import by.epam.task5.command.Command;
import by.epam.task5.command.CommandName;
import by.epam.task5.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private Map<CommandName, Command> commands = new HashMap<>();
    private static volatile CommandHelper instance;

    private CommandHelper() {
        commands.put(CommandName.LOGIN, new LoginCommand());
        commands.put(CommandName.TO_REGISTRATION, new ToRegistrationPageCommand());
        commands.put(CommandName.REGISTER, new RegisterCommand());
        commands.put(CommandName.LOGOUT, new LogoutCommand());
        commands.put(CommandName.TO_INDEX_PAGE, new ToIndexPageCommand());
    }

    public Command getCommand(String commandName) {
        Command command = null;
        CommandName key = null;

        commandName = commandName.replace('-','_').toUpperCase();
        key = CommandName.valueOf(commandName);
        command = commands.get(key);

        return command;
    }

    public static CommandHelper getInstance() {
        CommandHelper localInstance = instance;
        if (localInstance == null) {
            synchronized (CommandHelper.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new CommandHelper();
                }
            }
        }
        return localInstance;
    }
}

