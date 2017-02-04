package umm3601.todos;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class TodosController {

    private Todos[] todos;

    public TodosController() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/data/todos.json");
        todos = gson.fromJson(reader, Todos[].class);
    }

    //List all todos
    public Todos[] listTodos(Map<String, String[]> queryParams) {
        Todos[] filteredTodos = todos;
        if(queryParams.containsKey("status")) {
            boolean complete = Boolean.parseBoolean(queryParams.get("status")[0]);
            filteredTodos = filterTodosByComplete(filteredTodos, complete);
        }
        return filteredTodos;
    }

    /*public User[] filterTodosById(User[] filteredUsers, String id) {
        return Arrays.stream(filteredUsers).filter(x -> x.age == age).toArray(User[]::new);
    }*/

    public Todos[] filterTodosByComplete(Todos[] filteredTodos, boolean status) {
        return Arrays.stream(filteredTodos).filter(x -> x.status == true).toArray(Todos[]::new);
    }

    public Todos getTodos(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }


}
