/**
 * Created by ferri082 on 2/6/17.
 */
describe('testing basic functions' ,function() {

    it('should return the correct url', function() {
        expect(mainTodoFunction(url)).toEqual("/api/todos");
    })

    it('should return the limited list of todos', function(){
      var limitText = 7;
      expect(mainTodoFunction("?limit=" + limitText)).toEquals("/api/todos?limit=7");
    })

    it('should return the body with the word esse', function(){
        var bodyText = "esse";
        expect(mainTodoFunction("?contains=" + bodyText)).toEquals("/api/todos?contains=esse");
    })

    it('should return the todos with the specified owner', function(){
        var ownerText = "Blanche";
        expect(mainTodoFunction("?owner=" + ownerText)).toEquals("/api/todos?owner=Blanche");
    })

    it('should return the todos with the specified category', function(){
        var categoryText = "video games";
        expect(mainTodoFunction("?category=" + categoryText)).toEquals("/api/todos?category=categoryText");
    })

    it('should return the todos with completion', function(){
        expect(mainTodoFunction("?status=complete")).toEquals("/api/todos?status=complete");
    })
});