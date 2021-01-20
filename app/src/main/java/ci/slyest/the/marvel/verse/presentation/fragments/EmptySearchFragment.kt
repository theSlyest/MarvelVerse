package ci.slyest.the.marvel.verse.presentation.fragments

class EmptySearchFragment : ISearchFragment() {
    override fun initRecycler() {}
    override fun refresh(startsWith: String?) {}
}