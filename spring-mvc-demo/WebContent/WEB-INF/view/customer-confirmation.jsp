	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>
The customer confirmed : ${customer.firstName} ${customer.lastName}

<br><br>

Free Passes : ${customer.freePasses}

<br><br>

Postal Code : ${customer.postalCode}
<br><br>

Course Code : ${customer.courseCode}
</body>
</html>