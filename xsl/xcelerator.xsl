<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:fo="http://www.w3.org/1999/XSL/Format">
  <xsl:output method="xml" indent="yes"/>

  <xsl:attribute-set name="function-name">
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="function-description">
    <xsl:attribute name="space-after">1em</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="code-style">
    <xsl:attribute name="font-family">Courier</xsl:attribute>
    <xsl:attribute name="font-size">10pt</xsl:attribute>
  </xsl:attribute-set>

  <xsl:template match="/document">
    <fo:root>
      <fo:layout-master-set>
	<fo:simple-page-master master-name="cover-page"
			       page-height="297mm" 
			       page-width="210mm" 
			       margin="30mm"
			       margin-top="50mm"
			       margin-right="30mm">
	  <fo:region-body font-family="Helvetica"/>
	  <fo:region-after extent="25mm"
			   font-family="Helvetica"/>
	</fo:simple-page-master>
	
	<fo:simple-page-master master-name="license-page"
			       page-height="297mm" 
			       page-width="210mm" 
			       margin="30mm"
			       margin-top="50mm"
			       margin-right="30mm">
	  <fo:region-body font-family="Helvetica" font-size="10pt"/>
	  <fo:region-after extent="20mm"
			   font-family="Helvetica"/>
	</fo:simple-page-master>

	<fo:simple-page-master master-name="content-page"
			       page-height="29.7cm" 
			       page-width="21.0cm"
			       margin-top="50mm"
			       margin-bottom="10mm"
			       margin-left="30mm"
			       margin-right="30mm">
	  <fo:region-body font-family="Helvetica" font-size="10pt" margin-bottom="30mm"/>
	  <fo:region-after region-name="PageFooter"
			   extent="15mm"/>
	</fo:simple-page-master>
      </fo:layout-master-set>

      <!-- Document structure is defined here -->
      <fo:page-sequence master-reference="cover-page">
	<!-- 
	     The cover page contains some hard coded data in the
	     template. All these data is stored here.
	-->
	<fo:static-content flow-name="xsl-region-after">
	  <fo:block font-size="10pt" text-align="end">
	    EMC Corporation
	  </fo:block>
	  <fo:block font-size="10pt" text-align="end">
	    Corporate Headquarters:
	  </fo:block>
	  <fo:block font-size="10pt" text-align="end">
	    Hopkinton, MA 01748–9103
	  </fo:block>
	  <fo:block font-size="10pt" text-align="end">
	    1–508–435–1000
	  </fo:block>
	  <fo:block font-size="10pt" text-align="end">
	    www.EMC.com
	  </fo:block>
	</fo:static-content>

	<fo:flow flow-name="xsl-region-body">
	  <fo:block font-size="28pt" font-weight="bold" text-align="end">
	    EMC&#174; Documentum&#174; 
	  </fo:block>
	  <fo:block font-size="36pt" font-weight="bold" text-align="end">
	    xCelerated Composition
	  </fo:block>
	  <fo:block font-size="36pt" font-weight="bold" text-align="end">
	    Platform 
	  </fo:block>
	  <fo:block font-size="18pt" text-align="end" margin-top="5cm">
	    Version <xsl:value-of select="@version"/>
	  </fo:block>
	  <fo:block font-size="28pt" text-align="end">
	    <xsl:value-of select="title"/>
	  </fo:block>
	</fo:flow>
      </fo:page-sequence>

      <fo:page-sequence master-reference="license-page">
	<fo:flow flow-name="xsl-region-body">
	  <fo:wrapper font-size="10pt">
	    <fo:block>
	      EMC believes the information in this publication is accurate as of
	      its publication date. The information is subject to change without
	      notice.
	    </fo:block>
	    <fo:block space-before="2mm">
	      The information in this publication is provided as is. EMC Corporation
	      makes no representations or warranties of any kind with respect to the
	      information in this publication, and specifically disclaims implied
	      warranties of merchantability or fitness for a particular
	      purpose. Use, copying, and distribution of any EMC software described
	      in this publication requires an applicable software license.
	    </fo:block>
	    <fo:block space-before="2mm">
	      For the most up-to-date listing of EMC product names, see EMC
	      Corporation Trademarks on EMC.com. All other trademarks used herein
	      are the property of their respective owners.
	    </fo:block>
	    <fo:block space-before="2mm">
	      &#169; Copyright 2011 EMC Corporation. All rights reserved.
	    </fo:block>
	  </fo:wrapper>
	</fo:flow>
      </fo:page-sequence>
      
      <!-- Table of content pages is genereated here. -->
      <fo:page-sequence master-reference="content-page">
	<fo:flow flow-name="xsl-region-body">
	  <fo:block font-size="24pt" space-after="5mm">
	    Table of Contents
	  </fo:block>
	  <fo:block>
            <xsl:apply-templates select="(chapter|chapter/heading[not(../@notoc)])" mode="toc"/>
	  </fo:block>
	</fo:flow>
      </fo:page-sequence>

      <!-- Apply chapter content here -->
      <xsl:apply-templates select="chapter"/>
      
    </fo:root>
  </xsl:template>

  <!--
      Here is where the table of content is created. It will go
      through the xml document and for each chapter it will create a
      link to that chapter.
  -->
  <xsl:template match="chapter" mode="toc">
    <xsl:variable name="chapter-number">
      <xsl:number level="multiple" count="chapter" format="1.1.1"/>
    </xsl:variable>

    <fo:block space-before="2mm" font-size="12pt" text-align-last="justify">
      <fo:basic-link internal-destination="{generate-id(.)}">
	<xsl:value-of select="$chapter-number"/>.  <xsl:value-of select="@name"/>
	<fo:leader leader-pattern="dots"/>
	<fo:page-number-citation ref-id="{generate-id(.)}"/>
      </fo:basic-link>
    </fo:block>
  </xsl:template>
  
  <xsl:template match="h1" mode="toc">
    <fo:block space-before="2mm" padding-left="5mm" text-align-last="justify" keep-with-next="always">
      <xsl:variable name="chapter-number">
	<xsl:number level="multiple" count="chapter|h1" format="1.1.1"/>
      </xsl:variable>
      <xsl:value-of select="$chapter-number"/>.
      <xsl:value-of select="."/>
      <fo:leader leader-pattern="dots"/>
      <fo:page-number-citation ref-id="{generate-id(.)}"/>
    </fo:block>
  </xsl:template>

  <xsl:template match="h1">
    <fo:block font-size="18pt" id="{generate-id(.)}" space-before="10mm" space-after="4mm">
      <xsl:variable name="chapter-number">
	<xsl:number level="multiple" count="chapter|h1" format="1.1.1"/>
      </xsl:variable>
      <xsl:value-of select="$chapter-number"/>.
      <xsl:value-of select="."/>
    </fo:block>
  </xsl:template>
  
  <xsl:template match="h2">
    <fo:block font-size="14pt" 
	      id="{generate-id(.)}" 
	      space-before="2mm" 
	      space-after="1mm" 
	      keep-with-next="always">
      <xsl:value-of select="."/>
    </fo:block>
  </xsl:template>
  <!-- 
       This is where the content of the document is matched. The
       stylesheet will match each chapter and create a document
       based on the content of each chapter.       
  -->
  <xsl:template match="chapter">
    <xsl:variable name="chapter-number">
      <xsl:number level="multiple" count="chapter" format="1.1.1"/>
    </xsl:variable>
    
    <fo:page-sequence master-reference="content-page">
      <xsl:if test="$chapter-number=1">
	<xsl:attribute name="initial-page-number">
	  1
	</xsl:attribute>
      </xsl:if>

      <!-- Page Footer layout here-->
      <fo:static-content flow-name="PageFooter">
	<fo:block text-align-last="end"  border-top-style="solid">
	  <fo:page-number/>
	</fo:block>
      </fo:static-content>

      <fo:flow flow-name="xsl-region-body">
	<fo:block font-size="18pt" id="{generate-id(.)}" space-after="4mm">
	    <xsl:value-of select="$chapter-number"/>. 
	    <xsl:value-of select="@name"/>
	</fo:block>
	<xsl:apply-templates />
      </fo:flow>
    </fo:page-sequence>
  </xsl:template>

  <xsl:template match="code" mode="inline">
    <fo:inline xsl:use-attribute-sets="code-style">
      <xsl:apply-templates mode="inline"/>
    </fo:inline>
  </xsl:template>
  
  <xsl:template match="p">
    <fo:block>
      <xsl:apply-templates mode="inline"/>
    </fo:block>
  </xsl:template>

  <xsl:template match="function">
    <fo:block xsl:use-attribute-sets="code-style" keep-with-next="always">
      <xsl:apply-templates select="signature" mode="inline"/>
    </fo:block>
    <fo:block xsl:use-attribute-sets="function-description">
      <xsl:apply-templates select="description"/>
    </fo:block>
  </xsl:template>
  
  <xsl:template match="signature/name" mode="inline">
    <fo:inline xsl:use-attribute-sets="function-name">
      <xsl:apply-templates mode="inline"/>
    </fo:inline>
  </xsl:template>

  <xsl:template match="list">
    <fo:list-block>
      <xsl:apply-templates/>
    </fo:list-block>
  </xsl:template>
  
  <xsl:template match="numlist">
    <fo:list-block>
      <xsl:apply-templates/>
    </fo:list-block>
  </xsl:template>
  
  <xsl:template match="list/item">
    <fo:list-item>
      <fo:list-item-label start-indent="5mm" end-indent="label-end()">
	<fo:block>&#x2022;</fo:block>
      </fo:list-item-label>
      <fo:list-item-body start-indent="body-start()">
	<fo:block>
	  <xsl:apply-templates/>
	</fo:block>
      </fo:list-item-body>
    </fo:list-item>
  </xsl:template>

  <xsl:template match="numlist/item">
    <xsl:variable name="item-number">
      <xsl:number level="multiple" count="numlist/item" format="1"/>
    </xsl:variable>
    <fo:list-item  space-before="1em">
      <fo:list-item-label start-indent="0mm" end-indent="label-end()">
	<fo:block>
	  <xsl:value-of select="$item-number"/>.
	</fo:block>
      </fo:list-item-label>
      <fo:list-item-body start-indent="body-start()">
	<fo:block>
	  <xsl:apply-templates/>
	</fo:block>
      </fo:list-item-body>
    </fo:list-item>
  </xsl:template>
  
</xsl:stylesheet>