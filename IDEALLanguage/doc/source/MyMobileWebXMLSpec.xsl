<?xml version="1.0" encoding="utf-8"?>
<!--This file was created automatically by html2xhtml-->
<!--from the HTML stylesheets. Do not edit this file.-->
<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:saxon="http://icl.com/saxon" exclude-result-prefixes="saxon" version="2.0">
<xsl:import href="..\..\..\MyMobileWebUtil\XMLSpec\xmlspec.xsl" />
	<xsl:strip-space
		elements="    abstract arg attribute authlist author back bibref blist body case col    colgroup component constant constraint constraintnote copyright def    definitions descr div div1 div2 div3 div4 div5 ednote enum enumerator    example exception footnote front gitem glist graphic group header    htable htbody inform-div1 interface issue item itemizedlist langusage    listitem member method module note notice ol olist orderedlist orglist    param parameters prod prodgroup prodrecap proto pubdate pubstmt raises    reference resolution returns revisiondesc scrap sequence slist    sourcedesc spec specref status struct table tbody tfoot thead tr    typedef ul ulist union vc vcnote wfc wfcnote" />
<xsl:param name="toc.level" select="4"/>
<xsl:strip-space elements="author" />
<xsl:template match="header">
		<div xmlns="http://www.w3.org/1999/xhtml" class="head">
			<xsl:if test="not(/spec/@role='editors-copy')">
				<p>
					<a href="http://mymobileweb.morfeo-project.org/">
						<img
							src="http://mymobileweb.morfeo-project.org/wp-content/themes/morfeo/logos/logo_mymobileweb.png"
							alt="MyMW" />
					</a>
				</p>
			</xsl:if>
			<xsl:text>
</xsl:text>
			<h1>
				<xsl:call-template name="anchor">
					<xsl:with-param name="node" select="title[1]" />
					<xsl:with-param name="conditional" select="0" />
					<xsl:with-param name="default.id" select="'title'" />
				</xsl:call-template>
				<xsl:apply-templates select="title" />
				<xsl:if test="version">
					<xsl:text> </xsl:text>
					<xsl:apply-templates select="version" />
				</xsl:if>
			</h1>
			<xsl:if test="subtitle">
				<xsl:text>
</xsl:text>
				<h2>
					<xsl:call-template name="anchor">
						<xsl:with-param name="node"
							select="subtitle[1]" />
						<xsl:with-param name="conditional" select="0" />
						<xsl:with-param name="default.id"
							select="'subtitle'" />
					</xsl:call-template>
					<xsl:apply-templates select="subtitle" />
				</h2>
			</xsl:if>
			<xsl:text>
</xsl:text>
			<h2>
				<xsl:call-template name="anchor">
					<xsl:with-param name="node" select="w3c-doctype[1]" />
					<xsl:with-param name="conditional" select="0" />
					<xsl:with-param name="default.id"
						select="'w3c-doctype'" />
				</xsl:call-template>
				<xsl:apply-templates select="w3c-doctype" />
				<xsl:text> </xsl:text>
				<xsl:if test="pubdate/day">
					<xsl:apply-templates select="pubdate/day" />
					<xsl:text> </xsl:text>
				</xsl:if>
				<xsl:apply-templates select="pubdate/month" />
				<xsl:text> </xsl:text>
				<xsl:apply-templates select="pubdate/year" />
			</h2>
			<dl>
				<xsl:apply-templates select="publoc" />
				<xsl:apply-templates select="latestloc" />
				<xsl:apply-templates select="prevlocs" />
				<xsl:apply-templates select="authlist" />
			</dl>
			<!-- output the altlocs -->
			<xsl:apply-templates select="altlocs" />
			<xsl:choose>
				<xsl:when test="copyright">
					<xsl:apply-templates select="copyright" />
				</xsl:when>
				<xsl:otherwise>
							<p>
			Copyright © 2008-2009 <a href="http://www.tid.es/"><acronym title="Telefonica I+D">							Telefónica Investigación y Desarrollo,
								S.A. Unipersonal
							</acronym>
						</a>
			</p>
			
			<p>
			This work is licensed under a <a
							href="http://creativecommons.org/licenses/by-nc-sa/3.0/">
							<acronym
								title="Attribution-Noncommercial-Share Alike 3.0 Unported">
								Creative Commons Attribution-Noncommercial-Share Alike
								3.0 Unported
							</acronym>
							License.
						</a>
						This copyright applies to the XML infoset and accompanying documentation that is under the IDEAL namespace. Regarding underlying technology, IDEAL uses W3C's XForms, XMLEvents, RDFa, DISelect, Role Attribute and DIAL technology, which are open Web standards that can be freely used by anyone.
						</p>
				</xsl:otherwise>
			</xsl:choose>
		</div>
		<hr xmlns="http://www.w3.org/1999/xhtml" />
		<xsl:apply-templates select="notice" />
		<xsl:apply-templates select="abstract" />
		<xsl:apply-templates select="status" />
		<xsl:apply-templates select="revisiondesc" />
	</xsl:template>	
	
<!-- loc: a Web location -->
	<!-- outside the header, it's a normal cross-reference -->
	<xsl:template match="loc">
		<a xmlns="http://www.w3.org/1999/xhtml" href="{@href}">
			<xsl:apply-templates />
		</a>
	</xsl:template>
	
	<xsl:template match="w3c-doctype">
		<xsl:apply-templates />
	</xsl:template>
	
	<xsl:template name="css">
		<style xmlns="http://www.w3.org/1999/xhtml" type="text/css">
			<xsl:text>
code { font-family: monospace; }
div.constraint, div.issue, div.note, div.notice { margin-left: 2em; }
li p { margin-top: 0.3em; margin-bottom: 0.3em; }
                 
<!-- JRTL add styling from AWWW for noteboxes -->
      
.boxedtext {
   border: solid #bebebe 1px;
   margin: 2em 1em 1em 2em;
   padding: 0 0 10px 0;
 }
      
div.principle, div.practice, div.constraint, div.property, div.story {
   margin: -0.8em 0.5em 1em 1em;
 }

.principlelab, .constraintlab,
.propertylab, .practicelab,
.storylab {
   margin: -0.8em 0.5em 1em 1em;
   font-weight: bold;
   font-style: italic;
 }
 
p.principlelab span  { background: #f7ebd7 }
p.constraintlab span { background: #becece }
p.propertylab span  { background: #f7ebd7 }
p.practicelab span  { background: #dfffff }
p.storylab span { background: #005a9c; color: #fff; }

<!-- Tweak definition lists -->
dt {  margin-left: 2em}
dd { margin-left: 4em}

<!-- End of JRTL additions -->
            </xsl:text>
			<xsl:if test="$tabular.examples = 0">
				<xsl:text>
div.exampleInner pre { margin-left: 1em;
                       margin-top: 0em; margin-bottom: 0em}
div.exampleOuter {border: 4px double gray;
                  margin: 0em; padding: 0em}
div.exampleInner { background-color: #d5dee3;
                   border-top-width: 4px;
                   border-top-style: double;
                   border-top-color: #d3d3d3;
                   border-bottom-width: 4px;
                   border-bottom-style: double;
                   border-bottom-color: #d3d3d3;
                   padding: 4px; margin: 0em }
div.exampleWrapper { margin: 4px }
div.exampleHeader { font-weight: bold;
                    margin: 4px}
        </xsl:text>
			</xsl:if>
			<xsl:value-of select="$additional.css" />
		</style>
		<!--link xmlns="http://www.w3.org/1999/xhtml" rel="stylesheet" type="text/css">
			<xsl:attribute name="href"><xsl:text>http://www.w3.org/StyleSheets/TR/</xsl:text><xsl:choose><xsl:when test="/spec/@role='editors-copy'">base</xsl:when><xsl:otherwise><xsl:choose><xsl:when test="/spec/@w3c-doctype='wd'">W3C-WD</xsl:when><xsl:when test="/spec/@w3c-doctype='rec'">W3C-REC</xsl:when><xsl:when test="/spec/@w3c-doctype='pr'">W3C-PR</xsl:when><xsl:when test="/spec/@w3c-doctype='cr'">W3C-CR</xsl:when><xsl:when test="/spec/@w3c-doctype='note'">W3C-NOTE</xsl:when><xsl:otherwise>base</xsl:otherwise></xsl:choose></xsl:otherwise></xsl:choose><xsl:text>.css</xsl:text></xsl:attribute>
			</link-->
		<link xmlns="http://www.w3.org/1999/xhtml" rel="stylesheet"
			type="text/css">
			<xsl:attribute name="href"><xsl:text>http://files.morfeo-project.org/mymobileweb/public/res/custom.css</xsl:text>
			</xsl:attribute>
		</link>
		<link xmlns="http://www.w3.org/1999/xhtml" rel="stylesheet"
			type="text/css">
			<xsl:attribute name="href"><xsl:text>http://files.morfeo-project.org/mymobileweb/public/res/base.css</xsl:text>
			</xsl:attribute>
		</link>
		<link xmlns="http://www.w3.org/1999/xhtml" rel="stylesheet"
			type="text/css">
			<xsl:attribute name="href"><xsl:text>http://files.morfeo-project.org/mymobileweb/public/res/mymobileweb.css</xsl:text>
			</xsl:attribute>
		</link>
	</xsl:template>
	
	<xsl:template match="spec">
		<html xmlns="http://www.w3.org/1999/xhtml">
			<xsl:if test="header/langusage/language">
				<xsl:attribute name="lang"><xsl:value-of
						select="header/langusage/language/@id" />
				</xsl:attribute>
			</xsl:if>
			<head>
				<meta http-equiv="Content-Type"
					content="text/html; charset=UTF-8" />
				<title>
					<xsl:apply-templates select="header/title" />
					<xsl:if test="header/version">
						<xsl:text> </xsl:text>
						<xsl:apply-templates select="header/version" />
					</xsl:if>
					<xsl:if test="$additional.title != ''">
						<xsl:text> -- </xsl:text>
						<xsl:value-of select="$additional.title" />
					</xsl:if>
				</title>
				<xsl:call-template name="css" />
				<!-- JRTL added a link to the table of contents -->
				<link rel="contents" href="#contents" />
			</head>
			<body>
				<xsl:apply-templates />
				<xsl:if test="//footnote[not(ancestor::table)]">
					<hr />
					<div class="endnotes">
						<xsl:text>
</xsl:text>
						<h3>
							<xsl:call-template name="anchor">
								<xsl:with-param name="conditional"
									select="0" />
								<xsl:with-param name="default.id"
									select="'endnotes'" />
							</xsl:call-template>
							<xsl:text>End Notes</xsl:text>
						</h3>
						<dl>
							<xsl:apply-templates
								select="//footnote[not(ancestor::table)]" mode="notes" />
						</dl>
					</div>
				</xsl:if>
				<br />
				<div class="center">
					<a rel="license"
						href="http://creativecommons.org/licenses/by-nc-sa/3.0/">
						<img alt="Creative Commons License"
							style="border-width:0"
							src="http://i.creativecommons.org/l/by-nc-sa/3.0/88x31.png" />
					</a>
				</div>
			</body>
		</html>
	</xsl:template>
	
	  <!-- td/th are special -->
  <xsl:template match="td|th">
    <xsl:element name="{local-name(.)}" namespace="http://www.w3.org/1999/xhtml">
      <xsl:for-each select="@*">
        <!-- Wait: some of these aren't HTML attributes after all... -->
	<xsl:choose>
          <xsl:when test="local-name(.) = 'role'">
            <xsl:attribute name="class">
              <xsl:value-of select="."/>
            </xsl:attribute>
          </xsl:when>
          <xsl:when test="local-name(.) = 'diff'"/>
	  <xsl:otherwise>
            <xsl:copy-of select="."/>
          </xsl:otherwise>
        </xsl:choose>
      </xsl:for-each>
      <xsl:apply-templates/>
    </xsl:element>
  </xsl:template>

	</xsl:transform>
