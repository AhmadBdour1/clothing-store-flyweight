// Fetch and display inventory data
async function loadInventory() {
    try {
        const response = await fetch('/api/inventory');
        const items = await response.json();
        
        const tableBody = document.getElementById('inventoryTable');
        tableBody.innerHTML = ''; // Clear existing rows
        
        if (items.length === 0) {
            tableBody.innerHTML = '<tr><td colspan="9" class="loading">No items in inventory</td></tr>';
            return;
        }
        
        items.forEach(item => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${item.sku}</td>
                <td>${item.type}</td>
                <td>${item.brand}</td>
                <td>${item.design}</td>
                <td>${item.color}</td>
                <td>${item.size}</td>
                <td>$${item.price.toFixed(2)}</td>
                <td>${item.quantity}</td>
                <td>${item.location}</td>
            `;
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Error loading inventory:', error);
        document.getElementById('inventoryTable').innerHTML = 
            '<tr><td colspan="9" class="error">Error loading inventory data</td></tr>';
    }
}

// Fetch and display Flyweight statistics
async function loadStats() {
    try {
        const response = await fetch('/api/stats');
        const stats = await response.json();
        
        // Update statistics display
        document.getElementById('uniqueModels').textContent = stats.uniqueModels;
        document.getElementById('memorySaved').textContent = (stats.estimatedMemory / 1024).toFixed(2) + ' KB';
        
        // Calculate total items from inventory
        const inventoryResponse = await fetch('/api/inventory');
        const items = await inventoryResponse.json();
        document.getElementById('totalItems').textContent = items.length;
        
        // Calculate memory efficiency (percentage of shared models)
        if (items.length > 0) {
            const efficiency = ((stats.uniqueModels / items.length) * 100).toFixed(1);
            document.getElementById('savingPercentage').textContent = efficiency + '%';
        }
    } catch (error) {
        console.error('Error loading stats:', error);
    }
}

// Initialize the page
document.addEventListener('DOMContentLoaded', function() {
    loadInventory();
    loadStats();
    
    // Refresh data every 5 seconds (optional)
    // setInterval(() => {
    //     loadInventory();
    //     loadStats();
    // }, 5000);
});
