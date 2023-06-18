# WebView (Android)

---


## Supported Version
:star:	`Target Sdk Version: 33`

:star:	`Minimum Sdk Version: 24`

This sample uses the Gradle build system.

## Instructions

1. Download the samples by cloning this repository or downloading an archived snapshot.
2. In Android Studio, create a new project and choose the "Import non-Android Studio project" or "Import Project" option.
3. Select the App directory that you downloaded with this repository.
4. If prompted for a gradle configuration, accept the default settings. Alternatively use the "gradlew build" command to build the project directly.

### Branch naming

- Branch names are in [kebab-case](http://wiki.c2.com/?KebabCase)
- Feature branch names should be like `feature/branch-name`
- Bugfix branch names should be like `bugfix/branch-name`
- All `feature` and `bugfix` branches get merged into `develop` branch regularly
- `develop` branch is merged with `main` to deploy app into production
- Before a pull request is approved, you need to provide a debug build to our testing team for testing and approval

### Commit message style

We want to use [Conventional Commits](https://www.conventionalcommits.org) spec for commit messages.

If you'd like to know more, see [this](http://karma-runner.github.io/3.0/dev/git-commit-msg.html)
and [this](https://seesparkbox.com/foundry/semantic_commit_messages).

### Android code style

We have used Kotlin to develop our project. Please refer to [Kotlin coding style](https://kotlinlang.org/docs/reference/coding-conventions.html).

### Manage Gradle dependencies
- [Dependency management using buildSrc](https://medium.com/doubletapp/how-to-manage-gradle-dependencies-in-the-android-project-proper-way-dad51fd4fe7)
