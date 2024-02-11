
## Server-2: OSCLR Database Server

The Server-2 component of the Honors Enrolment Pre-assessment System (HEPaS) serves as the OSCLR (Open University of Science and Technology Course Learning Records) database server. It stores OUST students' course learning records, including unit selection/learning history and related unit results.

### Features:
- **Data Storage**: Stores student records, including personal information, course details, unit selection/learning history, and unit results.
- **Read-Only Access**: Student records in the OSCLR database are read-only to ensure data integrity and security. The HEPaS client cannot make any changes to student learning records.
- **Scalability**: Designed to handle a large volume of student data efficiently and effectively.
- **Sample Data Set**: Provides a sample data set (sampleDataSets.xlsx) for testing purposes, including tables for Student_Info, Course_Info, and Student_Unit.

### Usage:
- **Database Setup**: Populate the OSCLR database with sample data provided in the sampleDataSets.xlsx file or manually created data.
- **Data Access**: Server-1 communicates with Server-2 to retrieve student course learning records for HEPa assessment when requested by the client application.
- **Security**: Implements security measures to protect student data and ensure only authorized access.

### Technologies:
- **Database Management System**: Utilizes a relational database management system (e.g., MySQL, PostgreSQL, SQLite) for data storage.
- **Data Modeling**: Follows relational database principles for designing the database schema.
- **SQL**: Uses SQL (Structured Query Language) for querying and managing the database.

### Installation and Configuration:
- **Database Setup**: Follow the instructions provided in the repository's README to set up the OSCLR database and populate it with sample data.
- **Configuration**: Customize database connection settings as needed in the configuration files.

### Contribution Guidelines:
- **Reporting Issues**: Report any issues or bugs encountered with the Server-2 component using the repository's issue tracker.
- **Feature Requests**: Suggest new features or improvements to enhance the functionality of the OSCLR database server.
- **Pull Requests**: Contribute enhancements or fixes to the Server-2 component by submitting pull requests following the repository's contribution guidelines.

### License:
MIT

---

Feel free to adjust the content as needed to match your project's specifics and preferences!
