<!-- ...................................................................... -->
<!-- XML Events Module .................................................... -->
<!-- file: xml-events-1.mod

     This is XML Events - the Events Module for XML.
     a redefinition of access to the DOM events model.

     Copyright 2000-2003 W3C (MIT, ERCIM, Keio), All Rights Reserved.

     This DTD module is identified by the PUBLIC and SYSTEM identifiers:

       PUBLIC "-//W3C//ENTITIES XML Events 1.0//EN"
       SYSTEM "http://www.w3.org/MarkUp/DTD/xml-events-1.mod"

     Revisions:
     (none)
     ....................................................................... -->


<!-- XML Events defines the listener element and its attributes -->

<!ENTITY % xml-events.listener.content "EMPTY" >

<!ENTITY % XML.Events.extra.attrib "" >

<!ELEMENT %xml-events.listener.qname; %xml-events.listener.content;>

<![%XML-EVENTS.prefixed;[
<!ENTITY % XML-EVENTS.id.attrib
     "%XML-EVENTS.pfx;id         ID       #IMPLIED"
>
]]> 
<!ENTITY % XML-EVENTS.id.attrib
     "id         ID       #IMPLIED"
>

<![%XML-EVENTS.prefixed;[
<!ENTITY % XML-EVENTS.event.attrib
     "%XML-EVENTS.pfx;event         NMTOKEN      #REQUIRED"
>
]]> 
<!ENTITY % XML-EVENTS.event.attrib
     "event         NMTOKEN      #REQUIRED"
>

<![%XML-EVENTS.prefixed;[
<!ENTITY % XML-EVENTS.observer.attrib
     "%XML-EVENTS.pfx;observer         IDREF        #IMPLIED"
>
]]> 
<!ENTITY % XML-EVENTS.observer.attrib
     "observer         IDREF        #IMPLIED"
>

<![%XML-EVENTS.prefixed;[
<!ENTITY % XML-EVENTS.target.attrib
     "%XML-EVENTS.pfx;target         IDREF        #IMPLIED"
>
]]> 
<!ENTITY % XML-EVENTS.target.attrib
     "target         IDREF        #IMPLIED"
>

<![%XML-EVENTS.prefixed;[
<!ENTITY % XML-EVENTS.handler.attrib
     "%XML-EVENTS.pfx;handler         IDREF        #IMPLIED"
>
]]> 
<!ENTITY % XML-EVENTS.handler.attrib
     "handler          %anyURI.datatype;        #IMPLIED"
>

<![%XML-EVENTS.prefixed;[
<!ENTITY % XML-EVENTS.phase.attrib
     "%XML-EVENTS.pfx;phase         IDREF        #IMPLIED"
>
]]> 
<!ENTITY % XML-EVENTS.phase.attrib
     "phase          (capture|default)        #IMPLIED"
>

<![%XML-EVENTS.prefixed;[
<!ENTITY % XML-EVENTS.propagate.attrib
     "%XML-EVENTS.pfx;propagate         IDREF        #IMPLIED"
>
]]> 
<!ENTITY % XML-EVENTS.propagate.attrib
     "propagate          (stop|continue)        #IMPLIED"
>

<![%XML-EVENTS.prefixed;[
<!ENTITY % XML-EVENTS.defaultAction.attrib
     "%XML-EVENTS.pfx;defaultAction         IDREF        #IMPLIED"
>
]]> 
<!ENTITY % XML-EVENTS.defaultAction.attrib
     "defaultAction          (cancel|perform)        #IMPLIED"
>

<!ATTLIST %xml-events.listener.qname;
    %XML-EVENTS.id.attrib;
    %XML-EVENTS.event.attrib;
    %XML-EVENTS.observer.attrib;
    %XML-EVENTS.target.attrib;
    %XML-EVENTS.handler.attrib;
    %XML-EVENTS.phase.attrib;
    %XML-EVENTS.propagate.attrib;
    %XML-EVENTS.defaultAction.attrib;
    %XML.Events.extra.attrib;
>


<!-- end of xml-events-1.mod -->
