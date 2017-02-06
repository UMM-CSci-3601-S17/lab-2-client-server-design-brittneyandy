package umm3601.todos;

import org.junit.Test;
import umm3601.todos.Todos;
import umm3601.todos.TodosController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;

public class FilterTodosByIDSpec {

    @Test
    public void getFry() throws IOException {
        TodosController todosController = new TodosController();
        Todos TodosWithID = todosController.getTodos("58895985c1849992336c219b");
        assertEquals("Incorrect owner", "Fry", TodosWithID.owner);
    }

    @Test
    public void getDawn() throws IOException {
        TodosController todosController = new TodosController();
        Todos TodosWithID = todosController.getTodos("588959852a278361a5ea251a");
        assertEquals("Incorrect owner", "Dawn", TodosWithID.owner);
    }
}
