        package umm3601.todos;

        import org.junit.Test;
        import umm3601.todos.Todos;
        import umm3601.todos.TodosController;
        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;
        import static junit.framework.TestCase.assertEquals;

        public class FilterTodosByCombination {

        @Test
         public void filterTodosByCombination() throws IOException {
                TodosController todosController = new TodosController();
                Todos[] allTodos = todosController.listTodos(new HashMap<>());
                Todos[] CompleteTodos = todosController.filterTodosByComplete(allTodos, true);
                Todos[] OwnerTodos = todosController.filterTodosByOwner(CompleteTodos, "Blanche");
                assertEquals("Incorrect number of todos for true", 22, OwnerTodos.length);
                Todos[] LimitTodos = todosController.filterTodosByLimit(OwnerTodos, 12);
                assertEquals("Incorrect number of todos for true", 12, LimitTodos.length);
            }


        }
