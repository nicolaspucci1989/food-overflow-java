## Food overflow (student project)
![UML](img/Food%20Overflow_UML.jpg)
### Patterns present in this project
#### Composite (Recipes)
Recipes have the following attributes:
* Difficulty.
* Ingredients.
* Inadequate conditions.  
From the client's perspective recipes behave polymorphically.
The difficulty of a SimpleRecipe comes from it's attribute difficulty.
The difficulty of a CompoundRecipe is calculated from the maximum difficulty of all it's sub recipes
#### Strategy

### Food
* A particular food may be inappropriate for a set of nutritional conditions.

### Usuarios
* Users can posses any number of nutritional conditions.
* Users can be healthy or unhealthy depending on their nutritional conditions, their diet, and exercise routine.
* Users can create recipes.
* Users can contribute to recipes.

### Recipes
* Recipes have many ingredients
* Recipes are suggestible to a user depending on the user's nutritional condition and the recipe ingredients.
* Recipes can be simple or compound. Compound recipes have multiple sub recipes, which in turn can be simple or compound.
