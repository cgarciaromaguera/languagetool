/* LanguageTool, a natural language style checker 
 * Copyright (C) 2007 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.language;

import java.util.Arrays;
import java.util.List;

import org.languagetool.Language;
import org.languagetool.rules.CommaWhitespaceRule;
import org.languagetool.rules.DoublePunctuationRule;
import org.languagetool.rules.GenericUnpairedBracketsRule;
import org.languagetool.rules.Rule;
import org.languagetool.rules.pt.PortugueseCompoundRule;
import org.languagetool.rules.UppercaseSentenceStartRule;
import org.languagetool.rules.WhitespaceRule;
import org.languagetool.rules.WordRepeatRule;
import org.languagetool.rules.spelling.hunspell.HunspellNoSuggestionRule;
import org.languagetool.tagging.Tagger;
import org.languagetool.tagging.xx.DemoTagger;
import org.languagetool.tokenizers.SRXSentenceTokenizer;
import org.languagetool.tokenizers.SentenceTokenizer;

public class Portuguese extends Language {

  private Tagger tagger;
  private SentenceTokenizer sentenceTokenizer;

  @Override
  public String getName() {
    return "Portuguese";
  }

  @Override
  public String getShortName() {
    return "pt";
  }

  @Override
  public String[] getCountryVariants() {
    return new String[]{"AO", "MZ"};
  }

  @Override
  public Language getDefaultVariant() {
    return PORTUGUESE_PORTUGAL;
  }

  @Override
  public Contributor[] getMaintainers() {
    final Contributor contributor = new Contributor("Marco A.G. Pinto");
    contributor.setUrl("http://www.marcoagpinto.com/");
    return new Contributor[] { contributor };
  }

  @Override
  public Tagger getTagger() {
    if (tagger == null) {
      tagger = new DemoTagger();
    }
    return tagger;
  }

  @Override
  public SentenceTokenizer getSentenceTokenizer() {
    if (sentenceTokenizer == null) {
      sentenceTokenizer = new SRXSentenceTokenizer(this);
    }
    return sentenceTokenizer;
  }

  @Override
  public List<Class<? extends Rule>> getRelevantRules() {
    return Arrays.asList(
            CommaWhitespaceRule.class,
            DoublePunctuationRule.class,
            GenericUnpairedBracketsRule.class,
            HunspellNoSuggestionRule.class,
            UppercaseSentenceStartRule.class,
            WordRepeatRule.class,
            WhitespaceRule.class,
            //Specific to Portuguese
            PortugueseCompoundRule.class
    );
  }

}
