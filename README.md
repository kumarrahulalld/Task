## API Documentation

/customers:
    get:
      summary: "GET customers"
      operationId: "getAll"
      responses:
        "200":
          description: "OK"
    post:
      summary: "POST customers"
      operationId: "addCustomer"
      responses:
        "200":
          description: "OK"
---
  /customers/segment/{segment}:
    get:
      summary: "GET customers/segment/{segment}"
      operationId: "getCustomerBySegment"
      parameters:
      - name: "segment"
        in: "path"
        required: true
        schema:
          type: "string"
      responses:
        "200":
          description: "OK"
---
  /customers/{id}:
    get:
      summary: "GET customers/{id}"
      operationId: "getCustomerByID"
      parameters:
      - name: "id"
        in: "path"
        required: true
        schema:
          type: "number"
          format: "int64"
      responses:
        "200":
          description: "OK"
    delete:
      summary: "DELETE customers/{id}"
      operationId: "deleteCustomer"
      parameters:
      - name: "id"
        in: "path"
        required: true
        schema:
          type: "number"
          format: "int64"
      responses:
        "200":
          description: "OK"
---
  /customers/{id}/orders:
    get:
      summary: "GET customers/{id}/orders"
      operationId: "getOrders"
      parameters:
      - name: "id"
        in: "path"
        required: true
        schema:
          type: "number"
          format: "int64"
      responses:
        "200":
          description: "OK"
---
  /orders:
    get:
      summary: "GET orders"
      operationId: "getAllOrders"
      responses:
        "200":
          description: "OK"
    post:
      summary: "POST orders"
      operationId: "addOrder"
      responses:
        "200":
          description: "OK"
---
  /orders/{id}:
    get:
      summary: "GET orders/{id}"
      operationId: "getOrderByID"
      parameters:
      - name: "id"
        in: "path"
        required: true
        schema:
          type: "number"
          format: "int64"
      responses:
        "200":
          description: "OK"
