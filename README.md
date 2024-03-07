# Best Practices for REST API Development

## Accept and Respond with JSON

- **Accept Headers:** Ensure that your API accepts requests with the `application/json` content type.
- **Response Format:** Always respond with JSON formatted data to maintain consistency.

## Use Nouns Instead of Verbs in Endpoint Paths

- **Correct:** `/notes` or `/products`
- **Avoid:** `/getNotes` or `/createNote`

## Name Collections with Plural Nouns

- **Correct:** `/Notes` instead of `/note` for a collection of users.

## Nesting Resources for Hierarchical Objects

- **Hierarchical Structure:** Use nested resources for hierarchical relationships, such as `/organizations/{org_id}/users`.

## Handle Errors Gracefully and Return Standard Error Codes

- **Standard Error Codes:** Use HTTP status codes to indicate the status of the request (e.g., 404 for not found, 400 for bad request).
  
  `@GetMapping("/{id}")
    public ResponseEntity<Note> NoteById(@PathVariable Long id){
        Note note = noteServiceImp.getNoteById(id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }`

- **Error Messages:** Include informative error messages in the response body.

## Allow Filtering, Sorting, and Pagination

- **Query Parameters:** Support query parameters for filtering (`/users?status=active`), sorting (`/products?sort=name`), and pagination (`/users?page=1&pageSize=10`).

## Maintain Good Security Practices

- **Authentication:** Use secure authentication mechanisms such as OAuth 2.0.
- **Authorization:** Implement proper authorization checks to ensure users have the necessary permissions.
- **HTTPS:** Always use HTTPS to encrypt data in transit.

## Cache Data to Improve Performance

- **Caching Headers:** Utilize caching headers (e.g., `ETag`, `Cache-Control`) to improve API performance.
- **Consideration:** Cache responses for read-heavy APIs with infrequently changing data.

## Versioning Your APIs

- **API Version in URL:** Include the API version in the URL (e.g., `/v1/notes`).
- **Header Versioning:** Alternatively, use a custom header (e.g., `API-Version`) for versioning.


---


### Note Pad API Endpoints

#### Create a Note
- **Endpoint:** `POST /v1/notes`
- **Description:** Create a new note.

#### Get Note by ID
- **Endpoint:** `GET /v1/notes/{id}`
- **Description:** Retrieve a specific note by its unique identifier.

#### Get All Notes
- **Endpoint:** `GET /v1/notes`
- **Description:** Retrieve a list of all notes.

#### Update Note by ID
- **Endpoint:** `PUT /v1/notes/{id}`
- **Description:** Update an existing note by its unique identifier.

#### Edit Note by ID
- **Endpoint:** `PATCH /v1/notes/{id}`
- **Description:** Edit the content of an existing note by its unique identifier.

#### Delete Note by ID
- **Endpoint:** `DELETE /v1/notes/{id}`
- **Description:** Delete a specific note by its unique identifier.

#### Delete All Notes
- **Endpoint:** `DELETE /v1/notes`
- **Description:** Delete all notes.

---
