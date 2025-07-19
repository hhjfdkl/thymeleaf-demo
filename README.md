# Thymeleaf demo

- Thymeleaf is a very useful template processor for Spring Boot.
- You can make templates for various document types (HTML, XML, Text, JavaScript, CSS, plaintext) and have Thymeleaf populate those templates based on your code.
- Templates are stored in the `resources/templates` directory by default

# Notes on Thymeleaf

A templating engine to dynamically generate HTML pages from a Spring Boot application's backend

When used for developing a website, the workflow goes as follows:
- designer builds out an HTML document, populated with mock data
	- can then manipulate/test this with CSS & JavaScript
- Thymeleaf can be used to populate the placeholder data with dynamic data from elsewhere (app's persistence layer)

## Some syntax for the DOM
th:inline
th:text
th:utext -> Unescaped text *(renders actual HTML)* This is not sanitized
th:object
th:class
th:classappend
th:attr
th:if, th:unless - Conditionals
th:each - `<li th:each="product : ${products}/>` This is a for-each loop, but to add DOM element
th:source
th:href


Also use `?` as a "maybe" - null-safe in the DOM
- So `address.user?.firstName` will protect against null user value on address

## To use HTML in different templates...
You *could* manually inject with `th:utext`, but this is risky since it leaves the application vulnerable to XSS
Instead, you want to create a `fragments.html` document in your templates and then designate these as `th:fragment`

### Example:
(Courtesy of ChatGPT)
```html
<!-- templates/fragments.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Fragments</title>
</head>
<body>
  <!-- 🧩 Named fragment -->
  <div th:fragment="welcomeCard">
    <section class="card">
      <h3>Welcome</h3>
      <p>This is a reusable card fragment.</p>
    </section>
  </div>

  <!-- Another example -->
  <div th:fragment="footer">
    <footer>
      <p>&copy; 2025 My Website</p>
    </footer>
  </div>
</body>
</html>
```


The above fragments can then be injected into the primary index HTML file:
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Home</title>
  <link rel="stylesheet" th:href="@{/styles.css}" />
</head>
<body>

  <nav> ... </nav>

  <!-- 🧩 Insert welcome card -->
  <div th:replace="fragments :: welcomeCard"></div>

  <!-- 🧩 Insert footer -->
  <div th:replace="fragments :: footer"></div>

</body>
</html>
```

`fragments :: welcomeCard` pulls in data from the `fragments.html` document, where the fragment is titled `welcomeCard` (as designated above)
`th:replace` tells Thymeleaf to replace this section with whatever is in the designated section

### Example with Java
Now let's say we want to do this programmatically within Java:
```java
model.addAttribute("username", "Alice");
```
```html
<!-- In fragment -->
<div th:fragment="greeting(username)">
  <p>Hello, <span th:text="${username}">User</span>!</p>
</div>

<!-- In template -->
<div th:replace="fragments :: greeting(${username})"></div>
```
This is actually passing "Alice" down into the fragment
- `th:fragment="greeting(username)` defines a fragment named `greeting`. `(username)` declares a parameter that can be passed into the fragment.
- Because of this, the fragment can use `${username}` just like a model variable
In Java, it is essentially doing this:
```java
String greeting(String username) {
    return "<p>Hello, " + username + "</p>";
}
```
And just like how you write out a Java method, you can have more than just one parameter injected into a fragment with the same type of syntax: `th:fragment="display(title, subtitle, description)"` could be used with something like: `th:replace="fragments :: display(${mainTitle}, ${mainSubtitle}, ${mainDescription} )"` in the related div field.
- Fragment only cares about its own naming convention. What you call the input in the replace isn't important as long as the "method" call is proper *(so in this case, "display()" is important)*


# Some shortcomings of Thymeleaf
It's Server-rendered, meaning that in order for changes to display, you'll need to call the server each time
If you're doing Thymeleaf + plain JavaScript, UX could be harmed for highly dynamic web applications
- Meaning, web apps where there's high amounts of user input or highly active data updates. Since we're using the *server* to update data, without some funny adjustments, the user will likely need to refresh the page for data to update - **Not the expected, responsive user experience for modern web apps**
- There is some magic you can do through things like AJAX, but it isn't as good as using frontend frameworks

# Summary

Ultimately, Thymeleaf is great for small-mid sized web applications, particularly web apps with significantly more user read-only access than user write access, or apps that do not require many real-time updates for the user to see
- The example from my project is "Search-as-you-go". It will be more difficult to implement a live search *in the search bar* (think how some applications display results as you type) unless we use a front-end framework. However, Thymeleaf handles searches just fine; you just have to call the server to produce the updated document (or from UX - refresh the page)

> As an aside, apparently Thymeleaf is good for search engine optimization since it produces fully-rendered HTML that a search engine would see (and cares about)
> I can imagine that with dynamically updating terms in the HTML doc, you can game for SEO in some ways, but I'm not fully aware of how that works.

