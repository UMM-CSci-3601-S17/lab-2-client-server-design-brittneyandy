package umm3601.user;

import org.junit.Test;
import umm3601.todos.Todos;
import umm3601.todos.TodosController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

 public class FilterTodosBySize {

     @Test
     public void totalTodosCount() throws IOException {
         TodosController todosController = new TodosController();
         Todos[] allTodos = todosController.listTodos(new HashMap<>());
         assertEquals("Incorrect total number of todos", 300, allTodos.length);

     }


     @Test
     public void firstTodosInFullTodosList() throws IOException {
         TodosController todosController = new TodosController();
         Todos[] allTodos = todosController.listTodos(new HashMap<>());
         Todos firstTodos = allTodos[0];
         assertEquals("Incorrect owner", "Blanche", firstTodos.owner);
         assertEquals("Incorrect status", false, firstTodos.status);
         assertEquals("Incorrect body", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", firstTodos.body);
         assertEquals("Incorrect category", "software design", firstTodos.category);
     }
}
