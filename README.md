# GraphQL Demo Application

## Query examples

```
query {
  users {
    id,
    name,
    email
  }
}
```

```
query {
  users {
    id
  }
}
```

## Mutation examples

```
mutation {
    addUser(userInput: {name: "Rares Candrea", email: "rarescandrea@yahoo.com"}) {
        id,
        name,
        email
    }
}

mutation {
    updateUser(updatedUserInput: {name: "Andreea Vasile", email: "andreivasile@gmail.com"}) {
        id,
        name,
        email
    }
}

mutation {
    deleteUser(deletedUserInput: {email: "rarescandrea@yahoo.com"})
}
```
