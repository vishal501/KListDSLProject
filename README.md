# KList DSL Project

A Jetpack Compose DSL project inspired by the `Modifier` pattern, designed to declaratively build list-based UIs using a custom `KList` class.

## 🚀 Features
- Fluent API for building list UIs
- Padding modifier
- Multiple headers and sections
- Clickable items
- Dividers between items
- Animated item additions/changes
- Built using Kotlin and Jetpack Compose

## 🧱 Project Structure
```
├── KList.kt         // Core DSL class
├── KListItem.kt     // Reusable item UI
├── KListDemo.kt     // Example usage composable
```

## 🧩 Usage Example
Here's how you can use the custom `KList` DSL inside a Composable:

```kotlin
@Composable
fun KListDemo() {
    val topGainers = listOf("Bitcoin", "Ethereum", "Solana")
    val trending = listOf("Shiba Inu", "Dogecoin", "Pepe")
    val context = LocalContext.current

    KList.create<String>()
        .padding(16.dp)
        .section("Top Gainers", topGainers) {
            KListItem(it)
        }
        .section("Trending Now", trending) {
            KListItem(it)
        }
        .clickable { coin ->
            Toast.makeText(context, "Clicked on $coin", Toast.LENGTH_SHORT).show()
        }
        .withDividers()
        .render()
}
```

## 🧩 KList DSL Chainable Modifiers
- `.padding(dp: Dp)` – Adds padding to the entire list
- `.section(title: String, items: List<T>, content: @Composable (T) -> Unit)` – Adds a header and a section
- `.clickable {}` – Adds a click handler for each item
- `.withDividers()` – Adds dividers between items
- `.render()` – Renders the full list UI

## 📦 How to Run
- Clone the repository
- Open in Android Studio
- Run the `KListDemo()` composable inside a Compose-enabled activity or preview

## ✅ Evaluation Criteria Checklist
- [x] Fluent, chainable DSL
- [x] Multiple headers and sections
- [x] Padding modifier
- [x] Clickable items
- [x] Dividers between items
- [x] Animated item changes
- [x] Clean code structure
- [x] Proper Kotlin & Compose usage

## 📌 Known Issues
- None

## 👨‍💻 Author
Vishal Singh

---
Feel free to reach out for any queries or improvements!
