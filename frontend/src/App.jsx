
import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [products, setProducts] = useState([])
  const [cart, setCart] = useState([])

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
        .then(response => {
          if (!response.ok) throw new Error('Failed to load products')
          return response.json()
        })
        .then(data => setProducts(data))
        .catch(error => console.error(error))
  }, [])

  const addToCart = (product) => {
    setCart(previousCart => {
      const existing = previousCart.find(item => item.id === product.id)

      if (existing) {
        return previousCart.map(item =>
            item.id === product.id
                ? { ...item, cartQuantity: item.cartQuantity + 1 }
                : item
        )
      }

      return [...previousCart, { ...product, cartQuantity: 1 }]
    })
  }

  const total = cart.reduce(
      (sum, item) => sum + item.price * item.cartQuantity, 0
  )

  return (
      <div className="app">
        <nav className="navbar">
          <h2>ShopEasy</h2>
          <span>Home</span>
          <span>Products</span>
          <span>Cart 🛒 ({cart.reduce((sum, item) => sum + item.cartQuantity, 0)})</span>
        </nav>

        <header className="hero">
          <h1>Welcome to ShopEasy</h1>
          <p>Find your favourite electronics at great prices.</p>
        </header>

        <main className="container">
          <h2>Our Products</h2>

          <div className="product-grid">
            {products.map(product => (
                <div className="product-card" key={product.id}>
                  <div className="product-icon">🛍️</div>
                  <h3>{product.name}</h3>
                  <p>{product.description}</p>
                  <h3 className="price">₹{product.price}</h3>
                  <p>Available: {product.quantity}</p>
                  <button
                      onClick={() => addToCart(product)}
                      disabled={product.quantity <= 0}
                  >
                    Add to Cart
                  </button>
                </div>
            ))}
          </div>

          {products.length === 0 && <p>Loading products...</p>}

          <section className="cart-section">
            <h2>Your Shopping Cart</h2>

            {cart.length === 0 ? (
                <p>Your cart is empty.</p>
            ) : (
                <>
                  {cart.map(item => (
                      <p key={item.id}>
                        {item.name} × {item.cartQuantity} = ₹
                        {item.price * item.cartQuantity}
                      </p>
                  ))}
                  <h3>Total: ₹{total}</h3>
                </>
            )}
          </section>
        </main>

        <footer>© 2026 ShopEasy | Mini E-Commerce Project</footer>
      </div>
  )
}

export default App
