# ItemBuilder

## Using Item builder

### Creating an Block

```java
new ItemBuilder(Material.Material)
    // more arguments
    .build()
```

### Creating an Skull

```java
new ItemBuilder(UUID)
    // more arguments
    .build()
```

## Item Builder Arguments

```java
.setName(Component)-
.setLore(list<Component>)-
.addLoreLine(Component)-
.addEnchant(Enchantment, level)-
.addPlaceEvent(pdv)-
.addBlockBreakEvent(pdv)
.addBothClickEvent(pdv)
.addleftClickEvent(pdv)
.addRightClickEvent(pdv)
.addDropEvent(pdv)
.addWithItemBreakBlockEvent(pdv)
.addItemBreakEvent(pdv)
```

## Register events

_Event identifiers are mentiont as "pdv"_
_The addEvents methos need to be always called on start not only if the item is given_

### PlaceEvent

```java
ItemBuilderManager.addBlockPlaceEvent(pdv, (event) -> {
    // event code
})
```

### BlockBreakEvent

```java
ItemBuilderManager.addBlockBreakEvent(pdv, (event) -> {
    // event code
})
```

### BothClickEvent

```java
ItemBuilderManager.addBothClickEvent(pdv, (event) -> {
    // event code
})
```

### LeftClickEvent

```java
ItemBuilderManager.addLeftClickEvent(pdv, (event) -> {
    // event code
})
```

### RightClickEvent

```java
ItemBuilderManager.addRightClickEvent(pdv, (event) -> {
    // event code
})
```

### DropEvent

```java
ItemBuilderManager.addDropEvent(pdv, (event) -> {
    // event code
})
```

### ItemBreakBlockEvent

```java
ItemBuilderManager.addItemBreakBlockEvent(pdv, (event) -> {
    // event code
})
```

### ItemBreakEvent

```java
ItemBuilderManager.addItemBreakEvent(pdv, (event) -> {
    // event code
})
```
