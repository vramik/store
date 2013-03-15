<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<div class="portlet-section-header">Welcome !</div>

<br />

<!--<portlet:defineObjects/>-->

<div
    <portlet:actionURL var="myActionURL"/>
    <form action="<%= myActionURL %>" method="POST">
        <span class="portlet-form-field-label">Product:</span>
        <input class="portlet-form-input-field" type="text" name="product"/>
<!--        <span class="portlet-form-field-label">Quantity:</span>
        <input class="portlet-form-input-field" type="number" name="quantity"/>-->
        <input class="portlet-form-button" type="submit"/>
    </form>
</div>