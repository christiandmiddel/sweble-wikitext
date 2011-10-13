/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.sweble.wikitext.engine.CompilerException;
import org.sweble.wikitext.lazy.LinkTargetException;

public class AppTest
{
	@Test
	public void test() throws FileNotFoundException, IOException, LinkTargetException, CompilerException
	{
		String title = "Simple_Page";
		
		URL url = AppTest.class.getResource("/" + title + ".wikitext");
		
		StringBuilder b = new StringBuilder();
		
		b.append(App.run(new File(url.getFile()), title, "//InternalLink"));
		
		b.append(App.run(new File(url.getFile()), title, "//TableCell"));
		
		InputStream expectedIs = AppTest.class.getResourceAsStream("/" + title + ".result");
		String expected = IOUtils.toString(expectedIs);
		
		Assert.assertEquals(expected, b.toString());
	}
}
