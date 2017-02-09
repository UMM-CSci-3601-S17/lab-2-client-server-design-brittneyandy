describe('testing basic functions' ,function() {

    it('should return the correct url', function() {
        expect(mainTodoFunction("")).toEqual("/api/todos");
    });

    it('should return the limited list of todos', function(){
      var limitText = 7;
      expect(mainTodoFunction("?limit=" + limitText)).toEqual("/api/todos?limit=7");
    });

    it('should return the body with the word esse', function(){
        var bodyText = "esse";
        expect(mainTodoFunction("?contains=" + bodyText)).toEqual("/api/todos?contains=esse");
    });

    it('should return the todos with the specified owner', function(){
        var ownerText = "Blanche";
        expect(mainTodoFunction("?owner=" + ownerText)).toEqual("/api/todos?owner=Blanche");
    });

    it('should return the todos with the specified category', function(){
        var categoryText = "video games";
        expect(mainTodoFunction("?category=" + categoryText)).toEqual("/api/todos?category=categoryText");
    });

    it('should return the todos with completion', function(){
        expect(mainTodoFunction("?status=complete")).toEqual("/api/todos?status=complete");
    });
});