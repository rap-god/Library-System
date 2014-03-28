package ie.lyit.library;

/**
 * Class for initializing a new Book object.
 * @author Sean Morris - L00095752
 *
 */
public class Book {

	private int ISBN;
	private String author;
	private String title;
	private int publishedYear;
	private String genre;
	private String description;
	private String publisher;
	int quantity;
	private String imgPath;
	
	/**
	 * Constructor for instantiating a Book object. (Description not included)
	 * @param ISBN Book's unique ISBN number.
	 * @param author Book's author.
	 * @param title Book's title.
	 * @param publishedYear Year book was published.
	 * @param genre Book's Genre.
	 * @param publisher Book's publisher.
	 */
	
	public Book() {
		// Default empty constructor ...
	}
	public Book(int ISBN, String author, String title, int publishedYear, String genre, String publisher, int q) {
		this.ISBN = ISBN;
		this.author = author;
		this.title = title;
		this.publishedYear = publishedYear;
		this.genre = genre;
		this.publisher = publisher;
		this.quantity = q;
	}
	
	/**
	 * Constructor for instantiating a Book object. (Description included)
	 * @param ISBN Book's unique ISBN number.
	 * @param author Book's author.
	 * @param title Book's title.
	 * @param publishedYear Year book was published.
	 * @param genre Book's Genre.
	 * @param publisher Book's publisher.
	 */
	public Book(int ISBN, String author, String title, int publishedYear, String genre, String description, String publisher) {
		this.ISBN = ISBN;
		this.author = author;
		this.title = title;
		this.publishedYear = publishedYear;
		this.genre = genre;
		this.description = description;
		this.publisher = publisher;
		this.quantity = 1;
	}
	
	/**
	 * Retrieve the book's unique ISBN.
	 * @return The book's ISBN.
	 */
	public int getISBN() {
		return ISBN;
	}

	/**
	 * Set the book's ISBN.
	 * @param iSBN The book's unique ISBN number.
	 */
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	/**
	 * Retrieve the book's author.
	 * @return The name of the book's author.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Set the author.
	 * @param author The author's name.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Retrieve the book's title.
	 * @return The book's title.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Set the title of the book.
	 * @param title The book's title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Retrieve the year the book was published in.
	 * @return The year the book was published.
	 */
	public int getPublishedYear() {
		return publishedYear;
	}

	/**
	 * Set the year the book was published.
	 * @param publishedYear Year the book was published in.
	 */
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	/**
	 * Retrieve the books genre.
	 * @return The book's genre.
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Set the books genre.
	 * @param genre The book's genre.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Retrieve the book's description (synopsis).
	 * @return The book's description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description for the book.
	 * @param description The book's description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Retrieve the book's publisher.
	 * @return The name of the book's publisher.
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Set the book's publisher.
	 * @param publisher The name of the book's publisher.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Retrieve the quantity of books currently available ...
	 * @return Available quantity.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set the current quantity of books available.
	 * @param quantity Current quantity of books.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	/**
	 * Return the book's details as a string.
	 * @return The book's details as a string.
	 */
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", author=" + author + ", title=" + title
				+ ", publishedYear=" + publishedYear + ", genre=" + genre
				+ ", description=" + description + ", publisher=" + publisher
				+ ", quantity=" + quantity + "]";
	}

}
