package org.csystem.samples.commandprompt;

import org.csystem.util.StringUtil;

import java.util.Scanner;

public class CommandPromptApp {
    private String m_prompt;
    private static final String [] ms_commands = {"length", "reverse", "upper", "lower", "change"};

    private int getCommandIndex(String cmdStr)
    {
        if (cmdStr.length() < 3)
            return -1;

        for (int i = 0; i < ms_commands.length; ++i)
            if (ms_commands[i].startsWith(cmdStr))
                return i;

        return -1;
    }

    private void lengthProc(String [] commandsInfo)
    {
        System.out.println(commandsInfo[1].length());
    }

    private void reverseProc(String [] commandsInfo)
    {
        System.out.println(StringUtil.reverse(commandsInfo[1]));
    }

    private void upperProc(String [] commandsInfo)
    {
        System.out.println(commandsInfo[1].toUpperCase());
    }

    private void lowerProc(String [] commandsInfo)
    {
        System.out.println(commandsInfo[1].toLowerCase());
    }

    private void changeProc(String [] commandsInfo)
    {
        m_prompt = commandsInfo[1];
    }

    public CommandPromptApp(String p)
    {
        m_prompt = p;
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print(m_prompt + ">");
            String cmdStr = kb.nextLine().trim();

            String [] commandsInfo = cmdStr.split("[ \t]+");

            if (commandsInfo.length == 1 && commandsInfo[0].equals("quit"))
                break;

            int index = getCommandIndex(commandsInfo[0]);

            switch (index) {
                case 0:
                    lengthProc(commandsInfo);
                    break;
                case 1:
                    reverseProc(commandsInfo);
                    break;
                case 2:
                    upperProc(commandsInfo);
                    break;
                case 3:
                    lowerProc(commandsInfo);
                    break;
                case 4:
                    changeProc(commandsInfo);
                    break;
                default:
                    System.out.println("Geçersiz komut");
            }
        }

        System.out.println("Tekrar yapınız!!!");
    }
}
