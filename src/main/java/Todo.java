import picocli.CommandLine.*;

import java.io.*;

@Command(name = "Todo", version = "Todo 1.0", mixinStandardHelpOptions = true)
public class Todo implements Runnable{
    /*
    todo			: help
    todo <tasks>	: inserts tasks in the list, if no index is specified appends tasks to
                      the end of the list
    all accept indexes by default (indexes can be specified as a range with i-j syntax)
    todo -l			                : lists items
    todo -d			                : removes items
    todo -m			                : moves items
    todo --sort <{boolean}reverse>  : sorts items
    todo -r                         : returns elements with specified regex
     */

    private final String path = System.getProperty("user.home") + File.separator + "todo.txt";
    private final FileWriter fw = new FileWriter("path", true);
    private final BufferedWriter bw = new BufferedWriter(fw);
    private final PrintWriter out = new PrintWriter(bw);

    @Option(names = { "-l", "--list" }, description = "Lists items")
    String color = "";


    @Option(names = {"-a", "--add"}, description = "Add a task to the tasks list", split = ",")


    @Parameters(paramLabel = "<task>", defaultValue = "",
            description = "Tasks to be added to the tasks list separated by commas", split = ",")
    String[] tasks = new String[]{""};

    public Todo() throws IOException {

    }


    @Override
    public void run() {
        for(String task : tasks){
            out.println(task);
            System.out.println("Added " + "\"" + task + "\"" + " to the task list");
        }
    }


    public static void main(String[] args) {

    }


}
