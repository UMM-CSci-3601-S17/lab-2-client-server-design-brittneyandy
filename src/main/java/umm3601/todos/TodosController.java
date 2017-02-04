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

/*        // Filter id if defined
        if(queryParams.containsKey("_id")) {
            //int _id = String.parseInt(queryParams.get("age")[0]);
            String id = "_id";
            filteredTodos = filterTodosById(filteredTodos, "_id");
        }*/

        return filteredTodos;
    }

    /*public User[] filterTodosById(User[] filteredUsers, String id) {
        return Arrays.stream(filteredUsers).filter(x -> x.age == age).toArray(User[]::new);
    }*/

    public Todos getTodos(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }


}
