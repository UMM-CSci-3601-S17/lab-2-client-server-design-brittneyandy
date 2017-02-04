package umm3601.todos;
import java.util.Collections;

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

        /*if(queryParams.containsKey("limit")){
            int limit = Integer.parseInt(queryParams.get("limit")[0]);
            filteredTodos = filterTodosByLimit(filteredTodos, limit);
        }*/

        if(queryParams.containsKey("owner")) {
            String name = queryParams.get("owner")[0];
            filteredTodos = filterTodosByOwner(filteredTodos, name);
        }

        if(queryParams.containsKey("contains")) {
            String word = queryParams.get("contains")[0];
            filteredTodos = filterTodosByWord(filteredTodos, word);
        }

        if(queryParams.containsKey("category")) {
            String word = queryParams.get("category")[0];
            filteredTodos = filterTodosByCategory(filteredTodos, word);
        }

        
            return filteredTodos;

    }

    /*public User[] filterTodosById(User[] filteredUsers, String id) {
        return Arrays.stream(filteredUsers).filter(x -> x.age == age).toArray(User[]::new);
    }*/
    /*public Todos[] filterTodosByLimit(Todos[] filteredTodos, int limit) {
        Todos[] filteredTodos2 =  new Todos[limit];
        for (int i = 0; i < limit; i++){
            filteredTodos2[i] = filteredTodos[i];
        }
        return filteredTodos2;
    }*/

    public Todos[] filterTodosByCategory(Todos[] filteredTodos, String word) {
        return Arrays.stream(filteredTodos).filter(x -> x.category.equals(word)).toArray(Todos[]::new);
    }

    public Todos[] filterTodosByWord(Todos[] filteredTodos, String word) {
        return Arrays.stream(filteredTodos).filter(x -> x.body.contains(word)).toArray(Todos[]::new);
    }

    public Todos[] filterTodosByOwner(Todos[] filteredTodos, String name) {
        return Arrays.stream(filteredTodos).filter(x -> x.owner.equals(name)).toArray(Todos[]::new);
    }

    public Todos[] filterTodosByComplete(Todos[] filteredTodos, boolean status) {
        return Arrays.stream(filteredTodos).filter(x -> x.status == true).toArray(Todos[]::new);
    }

    public Todos getTodos(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }


}
