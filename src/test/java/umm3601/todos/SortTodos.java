package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SortTodos {

    @Test
    public void sortTodosByOwner() throws IOException {
        TodosController todosController = new TodosController();
        Todos[] allTodos = todosController.listTodos(new HashMap<>());
        Todos[] TodosSortedByOwner = todosController.sortingByOwner(allTodos);
        assertEquals("Incorrect number of todos", 300, TodosSortedByOwner.length);
        assertEquals("Incorrect first owner", TodosSortedByOwner[0].owner , "Barry");
        assertEquals("Incorrect Last owner",TodosSortedByOwner[299].owner, "Workman");
    }

    @Test
    public void sortTodosByCategory() throws IOException {
        TodosController todosController = new TodosController();
        Todos[] allTodos = todosController.listTodos(new HashMap<>());
        Todos[] TodosSortedByCategory = todosController.sortingByCategory(allTodos);
        assertEquals("Incorrect number of todos", 300, TodosSortedByCategory.length);
        assertEquals("Incorrect first category", TodosSortedByCategory[0].category , "groceries");
        assertEquals("Incorrect Last category",TodosSortedByCategory[299].category, "video games");
    }

    @Test
    public void sortTodosByStatus() throws IOException {
        TodosController todosController = new TodosController();
        Todos[] allTodos = todosController.listTodos(new HashMap<>());
        Todos[] TodosSortedByStatus = todosController.sortingByStatus(allTodos);
        assertEquals("Incorrect number of todos", 300, TodosSortedByStatus.length);
        assertTrue("Incorrect first status", TodosSortedByStatus[0].status == false);
        assertTrue("Incorrect Last status",TodosSortedByStatus[299].status== true);
    }

}

