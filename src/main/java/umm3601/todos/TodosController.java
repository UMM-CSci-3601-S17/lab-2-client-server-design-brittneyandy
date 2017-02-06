    package umm3601.todos;
    import com.google.gson.Gson;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Arrays;
    import java.util.Comparator;
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
                String complete = queryParams.get("status")[0];
                if(complete.equals("complete")){
                    Boolean completed = true;
                    filteredTodos = filterTodosByComplete(filteredTodos, completed);
                }
                if(complete.equals("incomplete")){
                    Boolean incompleted = false;
                    filteredTodos = filterTodosByInComplete(filteredTodos, incompleted);
                }
            }

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

            if(queryParams.containsKey("orderBy" )) {
                if (queryParams.get("orderBy")[0].equals("owner")){
                    filteredTodos = sortingByOwner(filteredTodos);
                }

                if (queryParams.get("orderBy")[0].equals("_id")){
                    filteredTodos = sortingByID(filteredTodos);
                }

                if (queryParams.get("orderBy")[0].equals("body")){
                    filteredTodos = sortingByBody(filteredTodos);
                }

                if (queryParams.get("orderBy")[0].equals("category")){
                    filteredTodos = sortingByCategory(filteredTodos);
                }
            }

            if(queryParams.containsKey("limit")){
                int limit = Integer.parseInt(queryParams.get("limit")[0]);
                filterTodosByLimit(filteredTodos, limit);
            }

            return filteredTodos;

        }

        public Todos[] sortingByCategory(Todos[] filteredTodos) {
            return Arrays.stream(filteredTodos).sorted(Comparator.comparing(x -> x.category)).toArray(Todos[]::new);
        }

        public Todos[] sortingByBody(Todos[] filteredTodos) {
            return Arrays.stream(filteredTodos).sorted(Comparator.comparing(x -> x.body)).toArray(Todos[]::new);
        }

        public Todos[] sortingByOwner(Todos[] filteredTodos) {
            return Arrays.stream(filteredTodos).sorted(Comparator.comparing(x -> x.owner)).toArray(Todos[]::new);
        }

        public Todos[] sortingByID(Todos[] filteredTodos) {
            return Arrays.stream(filteredTodos).sorted(Comparator.comparing(x -> x._id)).toArray(Todos[]::new);
        }

        public Todos[] filterTodosByLimit(Todos[] filteredTodos, int limit){
            Todos[] filteredTodos2 =  new Todos[limit];
            for (int i = 0; i < limit; i++){
                filteredTodos2[i] = filteredTodos[i];
            }
            return filteredTodos2;
        }

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

        public Todos[] filterTodosByInComplete(Todos[] filteredTodos, boolean status) {
            return Arrays.stream(filteredTodos).filter(x -> x.status == false).toArray(Todos[]::new);
        }

        public Todos getTodos(String id) {
            return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
        }


    }
