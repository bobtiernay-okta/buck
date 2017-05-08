/*
 * Copyright 2014-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.python;

import com.facebook.buck.cxx.CxxBuckConfig;
import com.facebook.buck.cxx.CxxPlatform;
import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.model.FlavorDomain;
import com.facebook.buck.rules.AbstractNodeBuilderWithMutableArg;
import com.facebook.buck.rules.SourcePath;
import com.facebook.buck.rules.SourceWithFlags;
import com.facebook.buck.rules.coercer.FrameworkPath;
import com.facebook.buck.rules.coercer.PatternMatchedCollection;
import com.facebook.buck.rules.coercer.SourceList;
import com.facebook.buck.rules.macros.StringWithMacros;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Optional;

public class CxxPythonExtensionBuilder
    extends AbstractNodeBuilderWithMutableArg<
        CxxPythonExtensionDescription.Arg, CxxPythonExtensionDescription, CxxPythonExtension> {

  public CxxPythonExtensionBuilder(
      BuildTarget target,
      FlavorDomain<PythonPlatform> pythonPlatforms,
      CxxBuckConfig cxxBuckConfig,
      FlavorDomain<CxxPlatform> cxxPlatforms) {
    super(new CxxPythonExtensionDescription(pythonPlatforms, cxxBuckConfig, cxxPlatforms), target);
  }

  public CxxPythonExtensionBuilder setBaseModule(String baseModule) {
    arg.baseModule = Optional.of(baseModule);
    return this;
  }

  public CxxPythonExtensionBuilder setPlatformDeps(
      PatternMatchedCollection<ImmutableSortedSet<BuildTarget>> platformDeps) {
    arg.platformDeps = platformDeps;
    return this;
  }

  public CxxPythonExtensionBuilder setModuleName(String moduleName) {
    arg.moduleName = Optional.of(moduleName);
    return this;
  }

  public CxxPythonExtensionBuilder setSrcs(ImmutableSortedSet<SourceWithFlags> srcs) {
    arg.srcs = srcs;
    return this;
  }

  public CxxPythonExtensionBuilder setHeaders(ImmutableSortedSet<SourcePath> headers) {
    arg.headers = SourceList.ofUnnamedSources(headers);
    return this;
  }

  public CxxPythonExtensionBuilder setHeaders(ImmutableSortedMap<String, SourcePath> headers) {
    arg.headers = SourceList.ofNamedSources(headers);
    return this;
  }

  public CxxPythonExtensionBuilder setCompilerFlags(ImmutableList<String> compilerFlags) {
    arg.compilerFlags = compilerFlags;
    return this;
  }

  public CxxPythonExtensionBuilder setPreprocessorFlags(ImmutableList<String> preprocessorFlags) {
    arg.preprocessorFlags = preprocessorFlags;
    return this;
  }

  public CxxPythonExtensionBuilder setLinkerFlags(ImmutableList<StringWithMacros> linkerFlags) {
    arg.linkerFlags = linkerFlags;
    return this;
  }

  public CxxPythonExtensionBuilder setFrameworks(ImmutableSortedSet<FrameworkPath> frameworks) {
    arg.frameworks = frameworks;
    return this;
  }

  public CxxPythonExtensionBuilder setLibraries(ImmutableSortedSet<FrameworkPath> libraries) {
    arg.libraries = libraries;
    return this;
  }

  public CxxPythonExtensionBuilder setDeps(ImmutableSortedSet<BuildTarget> deps) {
    arg.deps = deps;
    return this;
  }
}
