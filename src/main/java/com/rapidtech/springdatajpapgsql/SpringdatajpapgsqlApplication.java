package com.rapidtech.springdatajpapgsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdatajpapgsqlApplication {
	/*public class SpringdatajpapgsqlApplication implements CommandLineRunner {*/
	/*private final Logger LOG =
			LoggerFactory.getLogger(SpringdatajpapgsqlApplication.class);*/

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpapgsqlApplication.class, args);
	}

	/*@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void run(String... args) throws Exception {*/
		/*Book book1 = new Book();
		book1.setTitle("Spring Boot in Action");
		book1.setWriter("Erick Kurniawan");
		book1.setIsbn("IS-99887766");
		Book book2 = new Book();
		book2.setTitle("Spring Boot REST");
		book2.setWriter("Scott Gu");
		book2.setIsbn("IS-8877665");*/

		//bookRepository.save(book1);
		//bookRepository.save(book2);

		//tambah bookCategory
		/*BookCategory bookCategory1 = new BookCategory();
		bookCategory1.setName("Novel");
		BookCategory bookCategory2 = new BookCategory();
		bookCategory2.setName("History");
		bookCategoryRepository.save(bookCategory1);
		bookCategoryRepository.save(bookCategory2);*/
		/*BookCategory bookCategory = new BookCategory("Programming",
				new Book("Belajar Java","Erick Kurniawan","ISBN-77886699"),
				new Book("Belajar Spring Boot","Scott Hanselmen","99887766")
		);
		bookCategoryRepository.save(bookCategory);
		LOG.info("----- Berhasil menyimpan book category");*/

		/*List<Book> books = bookRepository.findAll();
		LOG.info("-----> Book: "+books.get(0).getTitle());
		LOG.info("-----> Book: "+books.get(1).getTitle());
		List<Book> bookByWriter = bookRepository.findAllByWriterContaining("Erick");
		LOG.info("-----> Book by Writer : "+bookByWriter.get(0).getTitle());
		Book myBook = bookRepository.findByIsbn("IS-99887766");
		LOG.info("-----> Book by Isbn : "+myBook.getTitle());
		List<Book> bookByIsbn = bookRepository.findAllByIsbnContaining("8");
		for (Book book:bookByIsbn) {
			LOG.info("-----> Book by ISBN : "+book.getTitle());
		}
		List<Book> nativeQuery = bookRepository.findAllQueryNative();
		for (Book book:bookByIsbn) {
			LOG.info("-----> Book Native : "+book.getTitle());
		}
		List<Book> booksWriteNative = bookRepository.findAllByWriterNative("Erick Kurniawan");
		for (Book book:booksWriteNative) {
			LOG.info("-----> Book Writer Native : "+book.getTitle());
		}*/

		//LOG.info("----- Berhasil menyimpan: "+book1.getTitle());
		//LOG.info("----- Berhasil menyimpan: "+book2.getTitle());


		/*Optional<BookCategory> bookCat = bookCategoryRepository.findById(Long.valueOf(3));
		Optional<Book> editBook = bookRepository.findById(2l);
		if(editBook.isPresent()){
			Book bookEdit = editBook.get();
			bookEdit.setBookCategory(bookCat.get());
			bookRepository.save(bookEdit);
			LOG.info("-----> Edit Book Category Berhasil");
		}
		else {
			LOG.warn("-----> Id Book tidak ditemukan");
		}*/

		/*List<Book> books = bookRepository.findAll();
		for(Book book : books)
		{
			LOG.info("-----> Book "+book.getTitle()+" - Category: "
					+ book.getBookCategory().getId() +" - "+  book.getBookCategory().getName());
		}*/
		/*Optional<BookCategory> bookCatOpt = bookCategoryRepository.findById(3l);
		if(bookCatOpt.isPresent()){
			BookCategory bookCat = bookCatOpt.get();
			List<Book> lstBook = bookRepository.findAllByBookCategory(bookCat);
			bookCat.setBooks(lstBook);
			//LOG.info("-----> "+bookCat.getBooks().get(0).getTitle());
			for(Book book:lstBook){
				LOG.info("----> "+book.getTitle());
			}
		}*/

		/*Student student1 = new Student();
		student1.setName("Jhon");
		student1.setAge(20);
		Student student2 = new Student("Tom",19);
		studentRepository.save(student1);
		studentRepository.save(student2);
		LOG.info("-----> Berhasil menambahkan data");
		Course course1 = new Course("Introduction to Spring Boot",12,1000);
		Course course2 = new Course("RESTful API with Spring Boot",15,1200);
		Course course3 = new Course("Spring Boot Microservices",12,1500);
		courseRepository.saveAll(Arrays.asList(course1,course2,course3));
		LOG.info("-----> Berhasil menambahkan data courses");*/

		//student1 ditambahkan ke course1
		/*Student student1 = studentRepository.findById(1l).get();
		Course course1 = courseRepository.findById(2l).get();
		student1.getCourses().add(course1);
		studentRepository.save(student1);
		LOG.info("-----> Berhasil mendaftarkan student1 ke course1");*/

		/*List<Student> students = studentRepository.findAll();
		for(Student student : students){
			LOG.info("-----> Student: "+student.getName());
			for(Course course : student.getCourses()){
				LOG.info("-------------> course: "+course.getTitle());
			}
		}

		List<Course> courses = courseRepository.findAll();
		for(Course course : courses){
			LOG.info("-----> Course: "+course.getTitle());
			for(Student student : course.getStudents()){
				LOG.info("----------------> Student: "+student.getName());
			}
		}*/
	//}
}