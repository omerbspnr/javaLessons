package org.csystem.samples.commandprompt;

import org.csystem.util.ArrayUtil;
import org.csystem.util.StringUtil;

import java.util.Scanner;

public class CommandPromptApp {
    private String m_prompt;
    private String [] m_commands = {"length","reverse", "upper", "lower", "change"};


    private void lengthProc(String [] commandsInfo)
    {
        System.out.println(commandsInfo[1].length());
    }
    private void reverseProc(String [] commandsInfo)
    {
        System.out.println(StringUtil.reverse(commandsInfo[1]));

    }
    private void upperProc (String [] commandsInfo)
    {
        System.out.println(commandsInfo[1].toUpperCase());
    }
    private void lowerProc (String [] commandsInfo)
    {

        System.out.println(commandsInfo[1].toLowerCase());
    }

    private void changeProc(String [] commandsInfo) {
        m_prompt = commandsInfo[1];
    }
    private boolean isTruePar(String s)
    {
        return s.startsWith("\"") && s.endsWith("\"");
    }
    private String getCommandPar(String [] commandsInfo)
    {

        String s = "";

        for (int i = 1; i < commandsInfo.length; ++i)
            s += commandsInfo[i] + " ";

        return s.substring(0, s.length() - 1);

    }
    private int getCommandIndex(String command)
    {
        if(command.length() < 3)
            return -1;

        for (int i = 0; i < m_commands.length; ++i)
            if (m_commands[i].startsWith(command))
                return i;

        return -1;
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

            if (commandsInfo.length == 1 && commandsInfo[0].equals("exit"))
                break;

            int index = getCommandIndex(commandsInfo[0]);


            String parameter = getCommandPar(commandsInfo);

            if (!isTruePar(parameter)) {
                System.out.println("Geçersiz Argüman");
                continue;
            }

            commandsInfo[1] = parameter.substring(1, parameter.length() - 1);

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
    }


}
