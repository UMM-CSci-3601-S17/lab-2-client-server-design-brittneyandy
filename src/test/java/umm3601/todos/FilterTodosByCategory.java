package umm3601.todos;

import org.junit.Test;
import umm3601.todos.Todos;
import umm3601.todos.TodosController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;

public class FilterTodosByCategory {
    @Test
    public void filterTodosByCategory() throws IOException {
        TodosController todosController = new TodosController();
        Todos[] allTodos = todosController.listTodos(new HashMap<>());
        Todos[] GroceriesTodos = todosController.filterTodosByCategory(allTodos, "groceries");
        assertEquals("Incorrect number of todos for groceries", 76, GroceriesTodos.length);
        Todos[] HomeworkTodos = todosController.filterTodosByCategory(allTodos, "homework");
        assertEquals("Incorrect number of todos for homework", 79, HomeworkTodos.length);
    }

}
