# Clothing Store - Flyweight Pattern Demo

This project is a practical implementation of the **Flyweight Structural Design Pattern** using **Java**, featuring a professional web-based Graphical User Interface (GUI) built with **HTML, CSS, and JavaScript**.

##  Overview
The primary goal of this project is to demonstrate how the Flyweight Pattern optimizes memory usage by sharing common data (Intrinsic State) across multiple objects instead of duplicating it in every instance.

##  Project Structure

| Path | Description |
| :--- | :--- |
| `src/.../flyweight/ClothingModel.java` | **Flyweight**: Stores shared intrinsic data (Brand, Color, Material, etc.). |
| `src/.../flyweight/ClothingModelFactory.java` | **Factory**: Manages the creation and reuse of `ClothingModel` objects. |
| `src/.../domain/ClothingItem.java` | **Context**: Stores unique extrinsic data (Size, SKU, Quantity) and a reference to the Model. |
| `src/.../ClothingStore.java` | **Client**: Manages the entire inventory list. |
| `src/.../Main.java` | **EntryPoint**: Runs the internal HTTP server and pre-loads demo data. |
| `resources/web/` | **GUI**: Frontend files (HTML, CSS, JavaScript). |

##  How the Flyweight Pattern is Demonstrated
Once you launch the web interface, you will see a **Statistics** section that clearly proves the memory efficiency:

1.  **Total Items**: The total number of clothing pieces in stock.
2.  **Unique Models**: The actual number of `ClothingModel` objects created in memory.
3.  **Memory Efficiency**: Shows the optimization percentage. The fewer unique models compared to total items, the higher the efficiency.

**Example:** If you have 100 Nike T-shirts of the same design but in different sizes, the program creates **only one** shared `ClothingModel` object and 100 small `ClothingItem` objects, significantly reducing memory footprint.

##  How to Run

### Prerequisites:
- **Java JDK 8** or higher installed.
- No external libraries or frameworks required.

### Quick Start:
- javac -d bin src/com/clothingstore/patterns/flyweight/*.java src/com/clothingstore/domain/*.java src/com/clothingstore/*.java

- 'java -cp bin com.clothingstore.Main'

### Manual Commands:
1.  **Compile:**
    `javac -d bin src/com/clothingstore/patterns/flyweight/*.java src/com/clothingstore/domain/*.java src/com/clothingstore/*.java`
2.  **Run:**
    `java -cp bin com.clothingstore.Main`
3.  **Access:** Open your browser and go to `http://localhost:8000`.

##  UI Technologies
- **HTML5**: For structured data and inventory tables.
- **CSS3**: For a modern, responsive design with professional color palettes.
- **JavaScript**: For fetching data from the Java backend and updating statistics dynamically.

---
**Developed as an educational demo for Design Patterns implementation.**