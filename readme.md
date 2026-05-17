[![](https://maven.gaminglounge.me/api/badge/latest/gaminglounge/me/gaminglounge/item-builder?color=40c14a&name=Item%20Builder&prefix=v&filter=none:SNAPSHOT)](https://maven.gaminglounge.me/#/gaminglounge/me/gaminglounge/item-builder)

# ItemBuilder

## [GuiAPI JavaDoc](https://maven.gaminglounge.me/javadoc/gaminglounge/me/gaminglounge/item-builder/latest)

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

_pdv is explained in **Register events**_

```java
.setName(Component)
.setLore(list<Component>)
.addLoreLine(Component)
.addEnchant(Enchantment, level)
.addPlaceEvent(pdv)
.addBlockBreakEvent(pdv)
.addBothClickEvent(pdv)
.addleftClickEvent(pdv)
.addRightClickEvent(pdv)
.addDropEvent(pdv)
.addWithItemBreakBlockEvent(pdv)
.addItemBreakEvent(pdv)
```

## Register events

_Event identifiers are mentiont as "pdv" and can for example be a string like this "plugin:name"_
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

### BothInteractionEvent

```java
ItemBuilderManager.bothInteractionEvent(pdv, (event) -> {
    // event code
})
```

### LeftInteractionEvent

```java
ItemBuilderManager.leftInteractionEvent(pdv, (event) -> {
    // event code
})
```

### RightInteractionEvent

```java
ItemBuilderManager.rightInteractionEvent(pdv, (event) -> {
    // event code
})
```
